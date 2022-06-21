package uz.pdp.spring_mvc_apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_mvc_apelsin.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
