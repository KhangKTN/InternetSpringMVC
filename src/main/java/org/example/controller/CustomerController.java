package org.example.controller;

import org.example.domain.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String getPageCreateCustomer(Model model) {
        model.addAttribute("model", new Customer());
        return "customer/save";
    }

    @PostMapping("")
    public String saveCustomer(@ModelAttribute("model") @Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customer/save";
        }
        model.addAttribute("message", customerService.saveCustomer(customer));
        return "customer/save";
    }

    @PostMapping("update")
    public String updateCustomer(@ModelAttribute("model") @Valid Customer customer, BindingResult bindingResult, RedirectAttributes ra, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("type", "edit");
            return "customer/save";
        }
        ra.addFlashAttribute("message", customerService.updateCustomer(customer));
        return "redirect:/customer/" + customer.getId();
    }


    @GetMapping("list")
    public String getCustomerList(Model model,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("maxPageItem") Optional<Integer> maxPageItem,
                                  @RequestParam("search") Optional<String> searchKey
    ) {
        Pageable pageable = new PageRequest(page.orElse(1) - 1, maxPageItem.orElse(2));
        Page<Customer> customerPage = customerService.getAllCustomers(pageable, searchKey);
        model.addAttribute("list", customerPage.getContent());
        model.addAttribute("totalPage", customerPage.getTotalPages());
        model.addAttribute("page", page.orElse(1));
        model.addAttribute("search", searchKey.orElse(""));
        return "customer/list";
    }

    @GetMapping("{id}")
    public String getUpdateCustomer(@PathVariable("id") String id, Model model) {
        model.addAttribute("type", "edit");
        model.addAttribute("model", customerService.getById(id));
        return "customer/save";
    }

    @GetMapping("delete/{id}/")
    public String deleteCustomer(@PathVariable("id") String customerId,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("maxPageItem") Optional<Integer> maxPageItem,
                                 RedirectAttributes ra) {
        ra.addFlashAttribute("message", customerService.deleteCustomer(customerId));
        return "redirect:/customer/list?" + "page=" + page.orElse(1) + "&maxPageItem=" + maxPageItem.orElse(2);
    }
}
