package org.example.repository;

import org.example.domain.CustomerComputer;
import org.example.domain.CustomerComputerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CustomerComputerRepository extends JpaRepository<CustomerComputer, CustomerComputerId>{

}
