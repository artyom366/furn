package office.furniture.test.service;

import office.furniture.test.domain.Rebate;
import office.furniture.test.jpa.RebateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by artyom on 15.27.11.
 */

@Service
public class RebateService {

    @Autowired
    private RebateRepository rebateRepository;

    public Iterable<Rebate> getAllRebates() {
        return rebateRepository.findAll();
    }

    public Rebate getRebateById(Long id) {
        return rebateRepository.findOne(id);
    }

    public Long saveRebate(Rebate rebate) {
        return rebateRepository.save(rebate).getId();
    }
}
