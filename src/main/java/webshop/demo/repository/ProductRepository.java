package webshop.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import webshop.demo.model.Product;

import java.util.Set;


public interface ProductRepository extends CrudRepository<Product, Long> {

}
