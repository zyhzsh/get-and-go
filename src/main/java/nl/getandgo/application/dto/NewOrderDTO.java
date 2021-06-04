package nl.getandgo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewOrderDTO {
    private Long customer_id;
    private Long voucher_id;
    private String email;
}
