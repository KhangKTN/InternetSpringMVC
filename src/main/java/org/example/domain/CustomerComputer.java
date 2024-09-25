package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "customer_computer")
@Getter @Setter
public class CustomerComputer{
    @EmbeddedId
    private CustomerComputerId customerComputerId;

//    @ManyToOne
//    @JoinColumn(name = "customerId")
//    @MapsId(value = "customerId")
//    Customer customer;
//
//    @ManyToOne
//    @JoinColumn(name = "computerId")
//    @MapsId(value = "computerId")
//    Computer computer;

    int timeUsed;
}
