package org.example.controller;

import org.example.domain.ServiceDomain;
import org.example.service.ServiceInternetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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
        model.addAttribute("message", serviceInternetService.saveService(service));
        return "service/save";
    }

    @GetMapping("list")
    public String getServiceList(Model model,
                                 @RequestParam("page") Optional<Integer> page,
                                 @RequestParam("maxPageItem") Optional<Integer> maxPageItem,
                                 @RequestParam("search") Optional<String> searchKey) {
        Pageable pageable = new PageRequest(page.orElse(1) - 1, maxPageItem.orElse(2));
        model.addAttribute("list", serviceInternetService.getAllServices(pageable, searchKey));
        model.addAttribute("totalPage", Math.ceil((double) serviceInternetService.countServices(searchKey) / maxPageItem.orElse(2)));
        model.addAttribute("page", page.orElse(1));
        model.addAttribute("search", searchKey.orElse(""));
        return "service/list";
    }

    @GetMapping("{id}")
    public String getUpdateService(@PathVariable String id, Model model){
        model.addAttribute("model", serviceInternetService.getById(id));
        return "service/save";
    }
}
