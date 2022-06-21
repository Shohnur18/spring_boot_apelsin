package uz.pdp.spring_mvc_apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_mvc_apelsin.entity.Detail;

public interface DetailRepository extends JpaRepository<Detail,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
