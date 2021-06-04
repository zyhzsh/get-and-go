package nl.getandgo.application.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatisticStoreTurnOverDTO {
    private String store_name;
    private Date date;
    private double turnover;
}
