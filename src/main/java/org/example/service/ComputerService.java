package org.example.service;

import org.example.domain.Computer;
import org.example.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ComputerService {
    @Autowired
    ComputerRepository computerRepository;

    public Computer getComputerById(Long id) {
        return computerRepository.findOne(id);
    }

    @Transactional
    public Long saveComputer(Computer computer) {
        computerRepository.save(computer);
        return computer.getId();
    }

    public List<Computer> getAllComputers(Pageable pageable) {
        return computerRepository.findAll(pageable).getContent();
    }

    public Long countAllComputer() {
        return computerRepository.count();
    }
}
