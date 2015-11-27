package office.furniture.test.api;

import office.furniture.test.domain.Rebate;
import office.furniture.test.jpa.RebateRepository;
import office.furniture.test.service.RebateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by artyom on 15.25.11.
 */

@RestController
@RequestMapping(value = "/api/rebates")
public class RebateController {

    @Autowired
    private RebateService rebateService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Rebate> getAllRebates() {
        return rebateService.getAllRebates();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Rebate getRebateById(@PathVariable("id") Long id) {
        return rebateService.getRebateById(id);
    }

    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public Long saveRebate(@RequestBody Rebate rebate) {
        return rebateService.saveRebate(rebate);
    }
}
