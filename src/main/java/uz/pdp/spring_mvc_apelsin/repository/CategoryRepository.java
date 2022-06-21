package uz.pdp.spring_mvc_apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_mvc_apelsin.entity.Category;


@Repository //bu siz ham ishlaydi
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    //native query -> sql
    //jpa query -> jpql
}
