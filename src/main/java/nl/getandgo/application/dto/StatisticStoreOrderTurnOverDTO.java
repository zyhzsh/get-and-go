package nl.getandgo.application.dto;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StatisticStoreOrderTurnOverDTO {
    private String store_name;
    private int month;
    private int quantity;
}
