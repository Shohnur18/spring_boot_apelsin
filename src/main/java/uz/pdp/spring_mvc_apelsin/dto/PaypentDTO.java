package uz.pdp.spring_mvc_apelsin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class PaypentDTO {
    private Timestamp time;
    private BigDecimal amount;
    private Integer invID;
}
