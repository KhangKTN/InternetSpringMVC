package org.example.service;

import org.example.domain.Customer;
import org.example.repository.CustomerComputerRepository;
import org.example.repository.CustomerRepository;
import org.example.repository.CustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerComputerRepository customerComputerRepository;

    @Autowired
    CustomerServiceRepository customerServiceRepository;

    @Transactional
    public String saveCustomer(Customer customer) {
        Customer currentCustomer = customerRepository.findById(customer.getId());
        if(currentCustomer != null) {
            return "Error! Customer ID already exists!";
        }
        customerRepository.save(customer);
        return "Customer successfully created!";
    }

    public String updateCustomer(Customer customer) {
        Customer currentCustomer = customerRepository.findById(customer.getId());
        if(currentCustomer == null) {
            return "Error! Customer not found!";
        }
        customer.setEmail(customer.getEmail());
        customerRepository.save(customer);
        return "Customer successfully updated!";
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Page<Customer> getAllCustomers(Pageable pageable, Optional<String> searchKey) {
        if(searchKey.isPresent()) {
            return customerRepository.findByNameContaining(pageable, searchKey.get());
        }
        return customerRepository.findAll(pageable);
    }

    public Customer getById(String id) {
        return customerRepository.findById(id);
    }

    public String deleteCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId);
        if(customer == null) {
            return "Error! Customer not found!";
        }
        if(customerComputerRepository.existsByCustomerComputerIdCustomerId(customerId)
            || customerServiceRepository.existsByCustomerServiceIdCustomerId(customerId)
        ){
            return "Error! Customer cannot delete!";
        }
//        customerRepository.delete(customer);
        return "Delete Customer successfully!";
    }
}
