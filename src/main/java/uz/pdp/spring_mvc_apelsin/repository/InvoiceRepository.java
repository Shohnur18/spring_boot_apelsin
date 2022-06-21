package uz.pdp.spring_mvc_apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_mvc_apelsin.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
