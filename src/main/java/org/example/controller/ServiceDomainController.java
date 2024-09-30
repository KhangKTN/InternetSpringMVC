package org.example.controller;

import org.example.domain.CustomerServiceId;
import org.example.domain.ServiceDomain;
import org.example.service.CustomerService;
import org.example.service.ServiceInternetService;
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
@RequestMapping("/service")
public class ServiceDomainController {
    @Autowired
    ServiceInternetService serviceInternetService;

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String getPageCreateService(Model model) {
        model.addAttribute("model", new ServiceDomain());
        return "service/save";
    }

    @PostMapping("")
    public String saveService(Model model,
                              @ModelAttribute("model") @Valid ServiceDomain service,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "service/save";
        }
        model.addAttribute("message", serviceInternetService.saveService(service));
        return "service/save";
    }

    @PostMapping("update")
    public String updateService(@ModelAttribute("model") @Valid ServiceDomain serviceDomain, BindingResult bindingResult, RedirectAttributes ra, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("type", "edit");
            return "service/save";
        }
        ra.addFlashAttribute("message", serviceInternetService.updateService(serviceDomain));
        return "redirect:/service/" + serviceDomain.getId();
    }

    @GetMapping("list")
    public String getServiceList(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("maxPageItem") Optional<Integer> maxPageItem,
                                 @RequestParam("search") Optional<String> searchKey) {

        Pageable pageable = new PageRequest(page.orElse(1) - 1, maxPageItem.orElse(2));
        Page<ServiceDomain> serviePage = serviceInternetService.getAllServices(pageable, searchKey);
        model.addAttribute("list", serviePage.getContent());
        model.addAttribute("totalPage", serviePage.getTotalPages());
        model.addAttribute("page", page.orElse(1));
        model.addAttribute("search", searchKey.orElse(""));
        return "service/list";
    }

    @GetMapping("{id}")
    public String getUpdateService(@PathVariable String id, Model model) {
        model.addAttribute("type", "edit");
        model.addAttribute("model", serviceInternetService.getById(id));
        return "service/save";
    }

    @GetMapping("register")
    public String getPageRegisterService(Model model) {
        org.example.domain.CustomerService cs = new org.example.domain.CustomerService();
        CustomerServiceId customerServiceId = new CustomerServiceId();
        customerServiceId.setDateUse();
        customerServiceId.setTimeUse();
        cs.setCustomerServiceId(customerServiceId);
        model.addAttribute("model", cs);


        model.addAttribute("customerList", customerService.getAllCustomer());
        model.addAttribute("serviceList", serviceInternetService.getAllServices());
        return "service/register";
    }

    @PostMapping("register")
    public String createRegisterService(@ModelAttribute() @Valid org.example.domain.CustomerService service, BindingResult bindingResult, RedirectAttributes ra) {
        if (bindingResult.hasErrors()) {
            ra.addFlashAttribute("message", "Error! " + bindingResult.getFieldError().getDefaultMessage());
            return "redirect:/service/register";
        }
        ra.addFlashAttribute("message", serviceInternetService.registerService(service));
        return "redirect:/service/register";
    }

    @GetMapping("delete/{id}/")
    public String deleteService(@PathVariable("id") String id,
                                @RequestParam("page") Optional<Integer> page,
                                @RequestParam("maxPageItem") Optional<Integer> maxPageItem,
                                RedirectAttributes ra) {
        ra.addFlashAttribute("message", serviceInternetService.deleteService(id));
        return "redirect:/service/list?" + "page=" + page.orElse(1) + "&maxPageItem=" + maxPageItem.orElse(2);
    }
}
