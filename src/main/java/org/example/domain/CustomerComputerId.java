package org.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
public class CustomerComputerId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "computerId")
    Computer computer;

    String startDate;

    String startTime;

    public CustomerComputerId() {}
}
