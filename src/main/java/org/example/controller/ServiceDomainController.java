package org.example.controller;

import org.example.domain.ServiceDomain;
import org.example.service.ServiceInternetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceDomainController {
    @Autowired
    ServiceInternetService serviceInternetService;

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
        serviceInternetService.saveService(service);
        return "service/save";
    }
}
