package org.example.service;

import org.example.domain.ServiceDomain;
import org.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceInternetService {
    @Autowired
    ServiceRepository serviceRepository;

    public String saveService(ServiceDomain serviceInternet) {
        return serviceRepository.save(serviceInternet).getId();
    }
}
