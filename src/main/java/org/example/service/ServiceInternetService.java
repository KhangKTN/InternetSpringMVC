package org.example.service;

import org.example.domain.ServiceDomain;
import org.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceInternetService {
    @Autowired
    ServiceRepository serviceRepository;

    public String saveService(ServiceDomain serviceInternet) {
        ServiceDomain service = this.getById(serviceInternet.getId());
        if (service != null) {
            return "Error! Service already exists!";
        }
        serviceRepository.save(serviceInternet);
        return "Service saved successfully";
    }

    public List<ServiceDomain> getAllServices(Pageable pageable, Optional<String> search) {
        if(search.isPresent()) {
            return serviceRepository.findByNameContaining(pageable, search.get());
        }
        return serviceRepository.findAll(pageable).getContent();
    }

    public Long countServices(Optional<String> search) {
        if(search.isPresent()) {
            return serviceRepository.findByNameContaining(search.get()).stream().count();
        }
        return serviceRepository.count();
    }

    public ServiceDomain getById(String id) {
        return serviceRepository.findById(id);
    }
}
