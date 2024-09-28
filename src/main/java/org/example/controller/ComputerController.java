package org.example.controller;

import org.example.domain.Computer;
import org.example.domain.CustomerComputer;
import org.example.domain.CustomerComputerId;
import org.example.service.ComputerService;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequestMapping("/computer")
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String getPageCreateComputer(Model model) {
        model.addAttribute("computer", new Computer());
        return "computer/save";
    }

    @PostMapping("")
    public String createComputer(@ModelAttribute("computer") @Valid Computer computer, BindingResult bindingResult, Model model, RedirectAttributes ra) {
        if (bindingResult.hasErrors()) {
            return "computer/save";
        }

        Long id = computerService.saveComputer(computer);
        if (id != 0) ra.addFlashAttribute("message", "Computer saved successfully");
        return "redirect:/computer";
    }

    @GetMapping("list")
    public String getListComputer(Model model,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("maxPageItem") Optional<Integer> maxPageItem) {

        Pageable pageable = new PageRequest(page.orElse(1) - 1, maxPageItem.orElse(2));
        model.addAttribute("list", computerService.getAllComputers(pageable).getContent());
//        model.addAttribute("totalPage", Math.ceil((double) computerService.countAllComputer() / maxPageItem.orElse(2)));
        model.addAttribute("totalPage", computerService.getAllComputers(pageable).getTotalPages());
        model.addAttribute("page", page.orElse(1));
        return "computer/list";
    }

    @GetMapping("register")
    public String getPageRegisterComputer(Model model) {
        CustomerComputer customerComputer = new CustomerComputer();
        CustomerComputerId customerComputerId = new CustomerComputerId();
        customerComputerId.setStartDate();
        customerComputerId.setStartTime();

        customerComputer.setCustomerComputerId(customerComputerId);

        model.addAttribute("model", customerComputer);
        model.addAttribute("customerList", customerService.getAllCustomer());
        model.addAttribute("computerList", computerService.getAllComputers());
        return "computer/register";
    }

    @PostMapping("register")
    public String createRegisterComputer(@ModelAttribute("model") @Validated CustomerComputer customerComputer, BindingResult bindingResult, Model model, RedirectAttributes ra) {
        if(bindingResult.hasErrors()) {
            ra.addFlashAttribute("message", "Error! " + bindingResult.getFieldError("timeUsed").getDefaultMessage());
            return "redirect:/computer/register";
        }

        if(LocalDate.parse(customerComputer.getCustomerComputerId().getStartDate()).isBefore(LocalDate.now())){
            ra.addFlashAttribute("message", "Error! " + "Date cannot be in the past");
            return "redirect:/computer/register";
        }

        ra.addFlashAttribute("message", computerService.registerComputer(customerComputer));

        return "redirect:/computer/register";
    }

    @GetMapping("{id}")
    public String getUpdateComputer(@PathVariable Long id, Model model) {
        model.addAttribute("computer", computerService.getById(id));
        return "computer/save";
    }
}
