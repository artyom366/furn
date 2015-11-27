package office.furniture.test.api;

import office.furniture.test.domain.Product;
import office.furniture.test.jpa.ProductRepository;
import office.furniture.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by artyom on 15.25.11.
 */

@RestController
@RequestMapping(value = "api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "put", method = RequestMethod.PUT)
    public Long saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
