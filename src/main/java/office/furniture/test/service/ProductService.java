package office.furniture.test.service;

import office.furniture.test.domain.Product;
import office.furniture.test.jpa.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by artyom on 15.27.11.
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findOne(id);
    }

    public Long saveProduct(Product product) {
        return productRepository.save(product).getId();
    }
}
