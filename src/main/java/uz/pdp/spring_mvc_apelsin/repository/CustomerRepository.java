package uz.pdp.spring_mvc_apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_mvc_apelsin.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
