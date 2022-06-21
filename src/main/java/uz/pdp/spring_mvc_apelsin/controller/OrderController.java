package uz.pdp.spring_mvc_apelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.spring_mvc_apelsin.dto.OrderDTO;
import uz.pdp.spring_mvc_apelsin.repository.CustomerRepository;
import uz.pdp.spring_mvc_apelsin.repository.OrderRepository;
import uz.pdp.spring_mvc_apelsin.repository.ProductRepository;
import uz.pdp.spring_mvc_apelsin.service.OrderService;


@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderService orderService;

    @GetMapping
    public String getListPage(Model model) {
        model.addAttribute("list", orderRepository.findAll());
        return "order/list";
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("customerList", customerRepository.findAll());
        model.addAttribute("productList", productRepository.findAll());
        return "order/add";
    }

    @PostMapping("/add")
    public String saveAddPage(@ModelAttribute OrderDTO orderDTO, Model model) {
        orderService.add(orderDTO, model);
        model.addAttribute("list", orderRepository.findAll());
        return "order/list";
    }


}
