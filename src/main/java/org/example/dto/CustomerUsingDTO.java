package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.CustomerComputer;

import java.util.List;

@Getter @Setter
public class CustomerUsingDTO {
    String startDate;
    String startTime;
    int timeUse;
    String customerId;
    String customerName;
    Long computerId;
    String position;
    List<ServiceUsingDTO> serviceUsingDTOList;
    long totalPrice;

    public static CustomerUsingDTO convertCustomerUsingDTO(CustomerComputer customerComputer, List<ServiceUsingDTO> serviceUsingList){
        CustomerUsingDTO customerUsingDTO = new CustomerUsingDTO();

        customerUsingDTO.setStartDate(customerComputer.getCustomerComputerId().getStartDate());
        customerUsingDTO.setStartTime(customerComputer.getCustomerComputerId().getStartTime());
        customerUsingDTO.setTimeUse(customerComputer.getTimeUsed());
        customerUsingDTO.setCustomerId(customerComputer.getCustomerComputerId().getCustomer().getId());
        customerUsingDTO.setCustomerName(customerComputer.getCustomerComputerId().getCustomer().getName());
        customerUsingDTO.setComputerId(customerComputer.getCustomerComputerId().getComputer().getId());
        customerUsingDTO.setPosition(customerComputer.getCustomerComputerId().getComputer().getPosition());
        customerUsingDTO.setServiceUsingDTOList(serviceUsingList);
        customerUsingDTO.setTotalPrice();
        return customerUsingDTO;
    }

    public void setTotalPrice() {
        this.totalPrice = 0;
        for(ServiceUsingDTO serviceUsingDTO : serviceUsingDTOList){
            this.totalPrice += serviceUsingDTO.getPrice();
        }
    }
}
