package webshop.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.demo.repository.DescriptionRepository;

@Service
public class DescriptionService {

    @Autowired
    DescriptionRepository descriptionRepository;
}
