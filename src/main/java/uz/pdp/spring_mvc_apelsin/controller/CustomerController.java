package uz.pdp.spring_mvc_apelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_mvc_apelsin.entity.Customer;
import uz.pdp.spring_mvc_apelsin.repository.CustomerRepository;
import uz.pdp.spring_mvc_apelsin.service.CustomerService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    final CustomerService customerService;
    final CustomerRepository customerRepository;

    @GetMapping
    public String getAll(Model model) {
        customerService.getAll(model);
        return "customer/list"; //page nomi -> list.html templates
    }

    @GetMapping("/add")
    public String getAddPage() {
//        model.addAttribute("category", null);
        return "customer/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute Customer customer, Model model) {
        customerService.add(model, customer);
        return "customer/list";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model) {
//        Category category = categoryRepository.getById(id); //1-variant
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found!" + id));
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditPage(@PathVariable Integer id, @ModelAttribute Customer customer, Model model) {
        customerService.edit(id, model, customer);
        return "customer/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(@PathVariable Integer id, Model model) {
        customerService.delete(id, model);
        return "customer/list";
    }
}
