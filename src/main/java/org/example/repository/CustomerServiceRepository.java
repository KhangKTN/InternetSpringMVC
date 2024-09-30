package org.example.repository;

import org.example.domain.CustomerService;
import org.example.domain.CustomerServiceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerServiceRepository extends JpaRepository<CustomerService, CustomerServiceId> {
//    @Query(
//            "SELECT new ServiceUsingDTO (c.id, cs.customerServiceId.dateUse, cs.customerServiceId.timeUse, cs.quantity)"
//        + " from CustomerService cs, Customer c"
//        + " where cs.customerServiceId.customer.id = c.id"
//        + " and c.id = ?1"
//    )
//    List<ServiceUsingDTO> findCustomerServiceByCustomer(String id);

    // Get all list service of customer by ID using computer
    @Query(value =
            "SELECT cs.dateUse, cs.timeUse, cs.quantity, s.name, s.price" +
            " from customer_service cs, customers c, services s" +
            " where cs.customerId = c.id" +
            " and cs.serviceId = s.id" +
            " and c.id = ?1" +
            " and CAST(CONCAT(cs.dateUse, ' ', cs.timeUse) as datetime)" +
            " BETWEEN" +
            " CAST(CONCAT(?2, ' ', ?3) as datetime)" +
            " AND DATE_ADD(CAST(CONCAT(?2, ' ', ?3) as datetime), INTERVAL ?4 MINUTE)"
    , nativeQuery = true)
    List<Object[]> findByCustomer(String customerId, String startDate, String startTime, int timeUse);

    boolean existsByCustomerServiceIdServiceDomainId(String serviceId);

    boolean existsByCustomerServiceIdCustomerId(String id);
}
