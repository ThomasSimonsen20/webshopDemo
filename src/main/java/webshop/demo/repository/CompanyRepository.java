package webshop.demo.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webshop.demo.model.Company;



public interface CompanyRepository extends CrudRepository<Company, Long> {


}
