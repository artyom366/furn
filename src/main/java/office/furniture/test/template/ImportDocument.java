package office.furniture.test.template;

import office.furniture.test.domain.Document;
import office.furniture.test.domain.DocumentLine;
import office.furniture.test.domain.Product;
import office.furniture.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by artyom on 15.27.11.
 */

@Component
public class ImportDocument  {

    @Autowired
    private ProductService productService;

    public void handleDocument(Document document) {
        System.out.println("Import export document");

        for (DocumentLine line : document.getLines()) {

            Product productDocument = line.getProduct();
            Product productDataBase = productService.getProductById(productDocument.getId());

            productDataBase.setStock(productDataBase.getStock() + line.getQuantity());

            productService.saveProduct(productDataBase);
        }
    }
}
