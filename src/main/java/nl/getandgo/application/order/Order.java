package nl.getandgo.application.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.voucher.Voucher;

import java.util.Date;

@AllArgsConstructor
@ToString
public class Order {
    @Getter @Setter private Long order_id;
    @Getter @Setter private Long customer_id;
    @Getter @Setter private Long store_id;
    @Getter @Setter private Long product_id;
    @Getter @Setter private Voucher voucher;
    @Getter @Setter private Date purchase_date;
    @Getter @Setter private String buyer_email;
    @Getter @Setter private OrderStatus orderStatus;
    public enum OrderStatus{
        Canceled,
        WaitForPay,
        Processing,
        Completed
    }
}
