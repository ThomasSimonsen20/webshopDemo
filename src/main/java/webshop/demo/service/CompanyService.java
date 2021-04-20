package webshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.demo.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;
}
