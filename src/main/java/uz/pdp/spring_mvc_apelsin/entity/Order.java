package uz.pdp.spring_mvc_apelsin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //serial
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer customer; //customer_id
}
