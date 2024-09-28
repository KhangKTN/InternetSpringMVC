package org.example.controller;

import org.example.domain.CustomerComputer;
import org.example.dto.CustomerUsingDTO;
import org.example.dto.ServiceUsingDTO;
import org.example.service.CustomerUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerUsingController {
    @Autowired
    CustomerUsingService customerUsingService;

    @GetMapping("/customer-using")
    public String customerUsing(Model model,
                                @RequestParam("page") Optional<Integer> pageReq,
                                @RequestParam("maxPageItem") Optional<Integer> maxPageItemReq) {
        Integer page = pageReq.orElse(1);
        Integer maxPageItem = maxPageItemReq.orElse(2);

        Pageable pageable = new PageRequest(page - 1, maxPageItem);

        Page<CustomerComputer> customerComputerPage = customerUsingService.findCustomerComputer(pageable);
        List<CustomerComputer> customerComputerList = customerComputerPage.getContent();

        model.addAttribute("page", page);
        model.addAttribute("maxPageItem", maxPageItem);
        model.addAttribute("totalPage", customerComputerPage.getTotalPages());

        List<CustomerUsingDTO> customerUsingDTOList = new ArrayList<>();
        for (CustomerComputer customerComputer : customerComputerList) {
            String customerId = customerComputer.getCustomerComputerId().getCustomer().getId();
            String startDate = customerComputer.getCustomerComputerId().getStartDate();
            String startTime = customerComputer.getCustomerComputerId().getStartTime();
            int timeUse = customerComputer.getTimeUsed();

            List<ServiceUsingDTO> serviceUsingDTOList = customerUsingService.getCustomerServiceByCustomerId(customerId, startDate, startTime, timeUse);

            customerUsingDTOList.add(CustomerUsingDTO.convertCustomerUsingDTO(customerComputer, serviceUsingDTOList));
        }
        model.addAttribute("list", customerUsingDTOList);
        return "customerUsing/show";
    }
}
