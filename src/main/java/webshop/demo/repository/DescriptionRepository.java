package webshop.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webshop.demo.model.Description;


public interface DescriptionRepository extends CrudRepository<Description, Long> {


}
