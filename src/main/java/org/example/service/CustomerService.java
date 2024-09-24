package org.example.service;

import org.example.domain.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public String saveCustomer(Customer customer) {
        return customerRepository.save(customer).getId();
    }

    public List<Customer> getAllCustomers(Pageable pageable, Optional<String> searchKey) {
        if(searchKey.isPresent()) {
            return customerRepository.findByNameContaining(pageable, searchKey.get());
        }
        return customerRepository.findAll(pageable).getContent();
    }

    public Long countAllCustomers(Optional<String> searchKey) {
        if(searchKey.isPresent()) {
            return customerRepository.countByNameContaining(searchKey.get());
        }
        return customerRepository.count();
    }
}
