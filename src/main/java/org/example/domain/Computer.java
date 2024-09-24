package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "computers")
@Getter @Setter
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Position is not blank")
    String position;
    @NotBlank(message = "Status is not blank")
    String status;

    @OneToMany(mappedBy = "computer")
    List<CustomerComputer> customerComputers;
}
