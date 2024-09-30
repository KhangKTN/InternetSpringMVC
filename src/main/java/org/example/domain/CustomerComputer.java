package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

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

    @Min(1)
    int timeUsed;
}
