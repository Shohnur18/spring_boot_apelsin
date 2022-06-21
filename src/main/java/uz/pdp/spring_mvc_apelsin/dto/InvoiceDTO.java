package uz.pdp.spring_mvc_apelsin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class InvoiceDTO {
    private Integer orId;
    private BigDecimal amount;
    private Date issued;
    private Date due;
}
