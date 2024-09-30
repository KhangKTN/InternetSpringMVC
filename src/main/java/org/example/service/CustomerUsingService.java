package org.example.service;

import org.example.domain.CustomerComputer;
import org.example.dto.ServiceUsingDTO;
import org.example.repository.CustomerComputerRepository;
import org.example.repository.CustomerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUsingService {
    @Autowired
    CustomerComputerRepository customerComputerRepository;

    @Autowired
    CustomerServiceRepository customerServiceRepository;

    public Page<CustomerComputer> findCustomerComputer(Pageable pageable) {
        return customerComputerRepository.findAll(pageable);
    }

    public List<ServiceUsingDTO> getCustomerServiceByCustomerId(String customerId, String startDate, String startTime, int timeUse) {
        List<Object[]> map = customerServiceRepository.findByCustomer(customerId, startDate, startTime, timeUse);
        List<ServiceUsingDTO> serviceUsingDTOList = new ArrayList<>();
        for (Object[] row : map) {
            ServiceUsingDTO serviceUsingDTO = new ServiceUsingDTO();

            serviceUsingDTO.setDateUse(LocalDate.parse((String) row[0]));
            serviceUsingDTO.setTimeUse(((Time) row[1]).toLocalTime());
            serviceUsingDTO.setQuantity((Integer) row[2]);
            serviceUsingDTO.setServiceName((String) row[3]);
            serviceUsingDTO.setPrice((Integer) row[4]);

            serviceUsingDTOList.add(serviceUsingDTO);
        }
        return serviceUsingDTOList;
    }
}
