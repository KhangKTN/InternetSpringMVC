package org.example.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "customer_service")
public class CustomerService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "serviceId")
    ServiceDomain service;
    @Id
    @Column(columnDefinition = "Date")
    LocalDate dateUse;

    @Id
    @Column(columnDefinition = "Time")
    LocalTime timeUse;
    int quantity;
}



