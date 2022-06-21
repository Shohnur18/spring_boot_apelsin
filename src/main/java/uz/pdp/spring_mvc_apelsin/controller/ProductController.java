package uz.pdp.spring_mvc_apelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.spring_mvc_apelsin.dto.ProductDTO;
import uz.pdp.spring_mvc_apelsin.entity.Product;
import uz.pdp.spring_mvc_apelsin.repository.CategoryRepository;
import uz.pdp.spring_mvc_apelsin.repository.ProductRepository;
import uz.pdp.spring_mvc_apelsin.service.ProductService;


@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public String getAll(Model model) {
        productService.getAll(model);
        return "product/list";// page nomi list.html templates ni ichida
    }

    @GetMapping("/add")
    public String getAddPage(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "product/add"; //page nomi -> list.html templates
    }

    @PostMapping("/add")
    public String getSavePage(@ModelAttribute ProductDTO productDto, Model model) {
        productService.add(model, productDto);
        return "product/list";
    }

    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "product/update";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Integer id, Model model) {
//        Category category = categoryRepository.getById(id); //1-variant
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found!" + id));
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryRepository.findAll());
        return "product/edit";
    }

    @PostMapping("/edit/{id}")
    public String saveEditPage(@PathVariable Integer id, @ModelAttribute ProductDTO productDTO, Model model) {
        productService.edit(id, model, productDTO);
        return "product/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteThroughId(@PathVariable(value = "id") int id, Model model) {
        productService.deleteById(id);
        productService.getAll(model);
        return "product/list";
    }
}
