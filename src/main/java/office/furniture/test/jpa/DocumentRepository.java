package office.furniture.test.jpa;

import office.furniture.test.domain.Document;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by artyom on 15.25.11.
 */
public interface DocumentRepository extends CrudRepository<Document, Long> {}
