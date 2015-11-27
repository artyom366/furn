package office.furniture.test.jpa;

import office.furniture.test.domain.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by artyom on 15.25.11.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {}
