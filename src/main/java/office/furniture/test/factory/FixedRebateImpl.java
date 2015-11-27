package office.furniture.test.factory;

import office.furniture.test.domain.Document;
import office.furniture.test.domain.DocumentLine;
import office.furniture.test.domain.Rebate;

/**
 * Created by artyom on 15.26.11.
 */

public class FixedRebateImpl implements IRebate {

    @Override
    public void calculateRebate(Document document, Rebate rebate) {

        float totalRebateAmount = (document.getTotalGrossAmount() / 100) * rebate.getDiscountPercentage();

        document.setTotalRebateAmount(document.getTotalRebateAmount() + totalRebateAmount);
        document.setTotalDocumentAmount(document.getTotalDocumentAmount() - totalRebateAmount);
    }
}
