package org.example.repository;

import org.example.domain.CustomerComputer;
import org.example.domain.CustomerComputerId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerComputerRepository extends JpaRepository<CustomerComputer, CustomerComputerId>{
    Page<CustomerComputer> findAll(Pageable pageable);

//    @Query(value = "from CustomerComputer cc"
//    + " where cc.customerComputerId.customer.id = ?1"
//    + " and CAST(CONCAT(cc.customerComputerId.startDate, ' ', cc.customerComputerId.startTime) as localdatetime ) < CURRENT_TIMESTAMP"
//    )
//    List<CustomerComputer> findCustomerUsingComputer(String customerId);

    @Query(value = "select *"
            + " from customer_computer c"
    + " where c.customerId = ?1"
    + " and DATE_ADD(CAST(CONCAT(c.startDate, ' ', c.startTime) as datetime), INTERVAL c.timeUsed MINUTE) > CURRENT_TIMESTAMP",
    nativeQuery = true)
    List<Object[]> findCustomerUsingComputer(String customerId);


    boolean existsByCustomerComputerIdComputerId(Long computerId);

    boolean existsByCustomerComputerIdCustomerId(String id);
}
