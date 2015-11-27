package office.furniture.test.template;

import office.furniture.test.domain.*;
import office.furniture.test.factory.IRebate;
import office.furniture.test.factory.RebateFactory;
import office.furniture.test.service.ClientService;
import office.furniture.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by artyom on 15.27.11.
 */

@Component
public class ExportDocument  {

    @Autowired
    private ProductService productService;

    @Autowired
    private ClientService clientService;


    public void handleDocument(Document document) {
        System.out.println("Handle export document");

        calculateTotals(document);
        calculateRebate(document);
        updateDataBase(document);
    }

    private void calculateTotals(Document document) {

        float totalNetAmount = 0f;

        for (DocumentLine line : document.getLines()) {

            Product product = productService.getProductById(line.getProduct().getId());
            float lineNetAmount = product.getPrice() * line.getQuantity();
            totalNetAmount += lineNetAmount;
        }

        float totalTaxAmount = (totalNetAmount * document.getTaxRate()) / 100;
        float totalGrossAmount = totalNetAmount + totalTaxAmount;

        document.setTotalTaxAmount(totalTaxAmount);
        document.setTotalGrossAmount(totalGrossAmount);
        document.setTotalDocumentAmount(totalGrossAmount);
    }

    private void calculateRebate(Document document) {

        Long clientId = document.getClient().getId();
        List<Rebate> clientRebates = clientService.getClientById(clientId).getRebates();

        for (Rebate rebate : clientRebates) {

            IRebate iRebate = RebateFactory.getRebate(rebate.getType());

            assert iRebate != null;
            iRebate.calculateRebate(document ,rebate);
        }
    }

    private void updateDataBase(Document document) {

        for (DocumentLine line : document.getLines()) {

            Product productDocument = line.getProduct();
            Product productDataBase = productService.getProductById(productDocument.getId());

            productDataBase.setStock(productDataBase.getStock() - line.getQuantity());

            productService.saveProduct(productDataBase);
        }
    }
}
