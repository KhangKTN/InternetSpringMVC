package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter @Setter
public class Customer {
    @NotBlank(message = "ID is not blank")
    @Pattern(regexp = "(KH)+([0-9]{5})", message = "ID must be KH*****")
    @Id
    String id;

    @NotBlank(message = "Name is not blank")
    String name;

    @NotBlank(message = "Address is not blank")
    String address;

    @NotBlank(message = "Phone is not blank")
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)+([0-9]{7})\\b", message = "Phone is invalid")
    String phone;

    @NotBlank(message = "Email is not blank")
    @Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$", message = "Email is invalid")
    String email;

    @OneToMany(mappedBy = "customerComputerId.customer", cascade = CascadeType.ALL)
    List<CustomerComputer> customerComputers;
}
