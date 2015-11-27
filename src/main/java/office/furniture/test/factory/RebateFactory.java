package office.furniture.test.factory;


import office.furniture.test.domain.Rebate;
import org.springframework.stereotype.Component;

/**
 * Created by artyom on 15.26.11.
 */

public class RebateFactory {

    public static IRebate getRebate(Rebate.TYPE type) {
        
        switch (type) {
            case TIME_OF_YEAR: {
                return new TimeOfYearRebateImpl();
            }

            case FIXED: {
                return new FixedRebateImpl();
            }

            case VOLUME: {
                return new VolumeRebateImpl();
            }

            default: {
                System.out.println("No rebate has been chosen");
            }
        }
        return null;
    }
}
