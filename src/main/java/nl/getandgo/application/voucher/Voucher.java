package nl.getandgo.application.voucher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Voucher {
    @Getter @Setter private Long voucher_id;
    @Getter @Setter private Long product_id;
    @Getter @Setter private Double price;
    @Getter @Setter private String title;
    @Getter @Setter private String description;
}
