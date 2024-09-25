package org.example.service;

import org.example.domain.Computer;
import org.example.domain.CustomerComputer;
import org.example.repository.ComputerRepository;
import org.example.repository.CustomerComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class ComputerService{
    @Autowired
    ComputerRepository computerRepository;

    @Autowired
    CustomerComputerRepository customerComputerRepository;

    public Computer getComputerById(Long id) {
        return computerRepository.findOne(id);
    }

    @Transactional
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
}
