package nl.getandgo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NewVoucherDTO {
    private Long product_id;
    private double price;
    private String title;
    private String description;
}
