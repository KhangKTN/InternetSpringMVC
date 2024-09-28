package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @OneToMany(mappedBy = "customerComputerId.computer", cascade = CascadeType.ALL)
    List<CustomerComputer> customerComputers;
}
