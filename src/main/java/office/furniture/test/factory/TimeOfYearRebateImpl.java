package office.furniture.test.factory;

import office.furniture.test.domain.Document;
import office.furniture.test.domain.Rebate;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by artyom on 15.26.11.
 */

public class TimeOfYearRebateImpl implements IRebate {

    private static final int[] seasons = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 0, 0};

    @Override
    public void calculateRebate(Document document, Rebate rebate) {

        int currentSeason = getSeason();

        if (currentSeason == rebate.getTimeOfYear().ordinal()) {

            float totalRebateAmount = (document.getTotalGrossAmount() / 100) * rebate.getDiscountPercentage();

            document.setTotalRebateAmount(document.getTotalRebateAmount() + totalRebateAmount);
            document.setTotalDocumentAmount(document.getTotalDocumentAmount() - totalRebateAmount);
        }
    }

    private int getSeason() {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);

        return seasons[month];
    }
}
