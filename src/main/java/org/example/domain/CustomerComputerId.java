package org.example.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
public class CustomerComputerId implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "customerId")
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "computerId")
    Computer computer;

    String startDate;

    String startTime;

    public CustomerComputerId() {}

    public void setStartDate() {
        this.startDate = LocalDate.now().toString();
    }

    public void setStartTime() {
        this.startTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    }
}
