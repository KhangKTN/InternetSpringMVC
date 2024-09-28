package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "customer_service")
@Getter @Setter
public class CustomerService{
    @EmbeddedId
    private CustomerServiceId customerServiceId;

    @Min(value = 1, message = "Quantity must be greater than 1")
    int quantity;
}



