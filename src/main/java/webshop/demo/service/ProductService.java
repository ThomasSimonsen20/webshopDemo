package webshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.demo.model.Product;
import webshop.demo.repository.ProductRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product) {
        productRepository.save(product);
    }


    public Product getProductById(Long id) {
        Optional<Product> optionalValue = productRepository.findById(id);

        return optionalValue.get();
    }


    public Set<Product> findAll() {
        Set<Product> products = new HashSet<>();

        for (Product product : productRepository.findAll()) {
            products.add(product);
        }

        return products;
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }
}
