package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "services")
@Getter @Setter
public class ServiceDomain {
    @NotBlank(message = "ID is not blank")
    @Pattern(regexp = "(DV)+([0-9]{3})", message = "ID must be DV***")
    @Column(length = 5, nullable = false)
    @Id
    String id;

    @NotBlank(message = "Name is not blank")
    String name;

    @NotBlank(message = "Name is not blank")
    String unit;

    @Min(1)
    Integer price;

    @OneToMany(mappedBy = "customerServiceId.serviceDomain")
    List<CustomerService> customerServices;
}
