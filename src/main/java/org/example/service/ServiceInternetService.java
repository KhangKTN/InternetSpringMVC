package org.example.service;

import org.example.domain.CustomerService;
import org.example.domain.CustomerServiceId;
import org.example.domain.ServiceDomain;
import org.example.repository.CustomerServiceRepository;
import org.example.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceInternetService {
    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    CustomerServiceRepository customerServiceRepository;

    @Autowired
    org.example.service.CustomerService customerService;

    @Autowired
    ComputerService computerService;

    public String saveService(ServiceDomain serviceInternet) {
        ServiceDomain service = this.getById(serviceInternet.getId());
        if (service != null) {
            return "Error! Service ID already exists!";
        }
        serviceRepository.save(serviceInternet);
        return "Service saved successfully";
    }

    public String updateService(ServiceDomain serviceInternet) {
        ServiceDomain service = this.getById(serviceInternet.getId());
        if (service == null) {
            return "Error! Service not found!";
        }
        serviceInternet.setId(service.getId());
        serviceRepository.save(serviceInternet);
        return "Service updated successfully";
    }

    public List<ServiceDomain> getAllServices() {
        return serviceRepository.findAll();
    }

    public Page<ServiceDomain> getAllServices(Pageable pageable, Optional<String> search) {
        if(search.isPresent()) {
            return serviceRepository.findByNameContaining(pageable, search.get());
        }
        return serviceRepository.findAll(pageable);
    }

    public ServiceDomain getById(String id) {
        return serviceRepository.findById(id);
    }

    public String registerService(CustomerService service) {
        String customerId = service.getCustomerServiceId().getCustomer().getId();

        if(!computerService.isCustomerUsing(customerId)){
            return "Error! Customer is not using computer!";
        }

        CustomerServiceId customerServiceId = service.getCustomerServiceId();

        String serviceId = service.getCustomerServiceId().getServiceDomain().getId();

        customerServiceId.setCustomer(customerService.getById(customerId));
        customerServiceId.setServiceDomain(this.getById(serviceId));

        service.setCustomerServiceId(customerServiceId);

        customerServiceRepository.save(service);
        return "Service registered successfully";
    }

    public String deleteService(String serviceId) {
        ServiceDomain service = this.getById(serviceId);
        if(service == null) {
            return "Error! Service not found!";
        }
        if(customerServiceRepository.existsByCustomerServiceIdServiceDomainId(serviceId)){
            return "Error! Service is cannot delete!";
        }
//        serviceRepository.delete(service);
        return "Deleted Service successfully";
    }
}
