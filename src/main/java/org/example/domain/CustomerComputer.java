package org.example.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "customer_computer")
public class CustomerComputer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "computerId")
    Computer computer;

    @Id
    @Column(columnDefinition = "Date")
    LocalDate startDate;

    @Id
    @Column(columnDefinition = "Time")
    LocalTime startTime;
    int timeUsed;
}
