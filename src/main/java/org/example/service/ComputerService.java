package org.example.service;

import org.example.domain.Computer;
import org.example.domain.CustomerComputer;
import org.example.domain.CustomerComputerId;
import org.example.repository.ComputerRepository;
import org.example.repository.CustomerComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Service
public class ComputerService{
    @Autowired
    ComputerRepository computerRepository;

    @Autowired
    CustomerComputerRepository customerComputerRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    ComputerService computerService;

    public Computer getComputerById(Long id) {
        return computerRepository.findOne(id);
    }

//    @Transactional
    public Long saveComputer(Computer computer) {
        computerRepository.save(computer);
        return computer.getId();
    }

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Page<Computer> getAllComputers(Pageable pageable) {
        return computerRepository.findAll(pageable);
    }


    public boolean createCustomerComputer(CustomerComputer customerComputer) {
        return customerComputerRepository.save(customerComputer) != null;
    }

    public Computer getById(Long id) {
        return computerRepository.findOne(id);
    }

    public boolean isCustomerUsing(String customerId) {
        return !customerComputerRepository.findCustomerUsingComputer(customerId).isEmpty();
    }

    public String registerComputer(CustomerComputer customerComputer) {
        String customerId = customerComputer.getCustomerComputerId().getCustomer().getId();

        if(isCustomerUsing(customerId)) {
            return "Error! This account register computer other!";
        }

        CustomerComputerId customerComputerId = customerComputer.getCustomerComputerId();

        Long computerId = customerComputerId.getComputer().getId();

        customerComputerId.setCustomer(customerService.getById(customerId));
        customerComputerId.setComputer(computerService.getById(computerId));

        customerComputer.setCustomerComputerId(customerComputerId);

        computerService.createCustomerComputer(customerComputer);
        return "Register computer successfully!";
    }
}
