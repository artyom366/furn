package office.furniture.test.factory;

import office.furniture.test.domain.Document;
import office.furniture.test.domain.Rebate;

/**
 * Created by artyom on 15.26.11.
 */
public interface IRebate {

    public void calculateRebate(Document document, Rebate rebate);
}
