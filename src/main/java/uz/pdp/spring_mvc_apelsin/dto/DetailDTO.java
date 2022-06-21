package uz.pdp.spring_mvc_apelsin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class DetailDTO {
    private Integer orId;
    private Integer proId;
    private Short quantity;
}
