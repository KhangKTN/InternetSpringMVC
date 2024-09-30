package org.example.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
public class CustomerServiceId implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    ServiceDomain serviceDomain;

    String dateUse;

    @Column(columnDefinition = "Time")
    LocalTime timeUse;

    public CustomerServiceId(){}

    public void setDateUse() {
        this.dateUse = LocalDate.now().toString();
    }

    public void setTimeUse() {
        this.timeUse = LocalTime.now();
    }
}
