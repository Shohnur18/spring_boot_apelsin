package uz.pdp.spring_mvc_apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_mvc_apelsin.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
