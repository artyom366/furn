package office.furniture.test.jpa;

import office.furniture.test.domain.Rebate;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by artyom on 15.25.11.
 */
public interface RebateRepository extends CrudRepository<Rebate, Long> {}
