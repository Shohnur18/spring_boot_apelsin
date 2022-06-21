package uz.pdp.spring_mvc_apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_mvc_apelsin.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
