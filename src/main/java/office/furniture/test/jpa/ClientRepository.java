package office.furniture.test.jpa;

import office.furniture.test.domain.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by artyom on 15.25.11.
 */

public interface ClientRepository extends CrudRepository<Client, Long> {}
