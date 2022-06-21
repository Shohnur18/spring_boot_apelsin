package uz.pdp.spring_mvc_apelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import uz.pdp.spring_mvc_apelsin.entity.Customer;
import uz.pdp.spring_mvc_apelsin.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void getAll(Model model) {
        List<Customer> customerList = customerRepository.findAll();
        model.addAttribute("list", customerList);
    }

    public void add(Model model, Customer customer) {
        customer.setName(customer.getName());
        customer.setCountry(customer.getCountry());
        customer.setAddress(customer.getAddress());
        customer.setPhone(customer.getPhone());
        customerRepository.save(customer);
        model.addAttribute("list", customerRepository.findAll());
    }


    public void edit(Integer id, Model model, Customer customer) {
        //editni logikasi
//        customerRepository.getById(); //bu null pointer exception
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer editedCustomer = optionalCustomer.get();
            editedCustomer.setName(customer.getName());
            editedCustomer.setCountry(customer.getCountry());
            editedCustomer.setAddress(customer.getAddress());
            editedCustomer.setPhone(customer.getPhone());
            customerRepository.save(editedCustomer); // malumot qo'shish
        }
        model.addAttribute("list", customerRepository.findAll(Sort.by("id")));
    }

    public void delete(Integer id, Model model) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(id);
        }
        model.addAttribute("list", customerRepository.findAll(Sort.by("id")));
    }
    
    public Customer getById(int id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException
                                ("Id not found!" + id));
    }

    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
