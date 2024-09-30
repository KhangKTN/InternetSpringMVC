package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "customer_service")
@Getter @Setter
public class CustomerService{
    @EmbeddedId
    private CustomerServiceId customerServiceId;

    @Min(value = 1, message = "Quantity must be greater than 1")
    int quantity;
}



