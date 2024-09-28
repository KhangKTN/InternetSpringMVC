package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class ServiceUsingDTO {
    String serviceName;
    LocalDate dateUse;
    LocalTime timeUse;
    int quantity;
    int price;
}
