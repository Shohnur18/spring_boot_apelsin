package uz.pdp.spring_mvc_apelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.spring_mvc_apelsin.dto.ProductDTO;
import uz.pdp.spring_mvc_apelsin.entity.Product;
import uz.pdp.spring_mvc_apelsin.repository.CategoryRepository;
import uz.pdp.spring_mvc_apelsin.repository.ProductRepository;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void getAll(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("list", productList);
    }

    public void add(Model model, ProductDTO productDto) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setName(productDto.getName());
        product.setPrice(BigDecimal.valueOf(productDto.getPrice()));
        //1-variant
//        Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCatId());
//        if (optionalCategory.isPresent()) {
//            Category category = optionalCategory.get();
//            product.setCategory(category);
//        }

        //yogini tanlay olmagani un mumkin
        product.setCategory(categoryRepository.getById(productDto.getCatId()));
        productRepository.save(product);
        model.addAttribute("list", productRepository.findAll());
    }

    public void edit(Integer id, Model model, ProductDTO productDTO) {
        //editni logikasi
//        customerRepository.getById(); //bu null pointer exception
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product editedProduct = optionalProduct.get();
            editedProduct.setName(productDTO.getName());
            editedProduct.setDescription(productDTO.getDescription());
            editedProduct.setCategory(categoryRepository.getById(productDTO.getCatId()));
            editedProduct.setPrice(BigDecimal.valueOf(productDTO.getPrice()));
            editedProduct.setPhoto(productDTO.getPhoto());
            productRepository.save(editedProduct); // malumot qo'shish
        }
        model.addAttribute("list", productRepository.findAll(Sort.by("id")));
    }

    public Product getById(int id) {
        return productRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException
                                ("Id not found!" + id));
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);


    }
}
