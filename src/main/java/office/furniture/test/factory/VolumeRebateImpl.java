package office.furniture.test.factory;

import office.furniture.test.domain.Document;
import office.furniture.test.domain.DocumentLine;
import office.furniture.test.domain.Rebate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by artyom on 15.26.11.
 */

public class VolumeRebateImpl implements IRebate {

    @Override
    public void calculateRebate(Document document, Rebate rebate) {

        float totalQuantity = 0f;

        for (DocumentLine line : document.getLines()) {
            totalQuantity += line.getQuantity();
        }

        float totalRebateAmount = 0f;
        if (totalQuantity >= rebate.getQuantityThreshold()) {
            totalRebateAmount = (document.getTotalGrossAmount() / 100) * rebate.getDiscountPercentage();

            document.setTotalRebateAmount(document.getTotalRebateAmount() + totalRebateAmount);
            document.setTotalDocumentAmount(document.getTotalDocumentAmount() - totalRebateAmount);
        }
    }
}
