package nl.getandgo.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@ToString
@NoArgsConstructor
@Entity(name = "Order")
@Table(name = "orders")
public class Order {

    /**
     * Order Id
     */
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_sequence"
    )
    @Column(name = "order_id")
    @Getter @Setter private Long order_id;

    /**
     * Customer Id
     * */
    @ManyToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    @Getter @Setter private CustomerUser customer;

    /**
     * Store Id
     * */
    @Column(name = "store_id",nullable = false)
    @Getter @Setter private Long store_id;

    /**
     * Product Id
     * */
    @Column(name = "product_id",nullable = false)
    @Getter @Setter private Long product_id;

    /**
     * Voucher
     * */
    @Column(name = "voucher_id")
    @Getter @Setter private Long voucher_id;


    /**
     * Created At
     * */
    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    @Getter @Setter private LocalDateTime createdAt;

    /**
     * Buyer's Email
     * */
    @Column(name = "buyer_email",nullable = false)
    @Getter @Setter private String buyer_email;

    /**
     * Detail
     * */
    @Column(name = "detail",nullable = false)
    @Getter @Setter private String detail;

    /**
     * Order Status
     * */
    @Column(name = "order_status",nullable = false)
    @Getter @Setter private OrderStatus orderStatus;

    /**
     * Order Status:
     * - Canceled,
     * - WaitForPay,
     * - Processing,
     * - Completed
     * */
    public enum OrderStatus {
        Canceled,
        WaitForPay,
        Processing,
        Completed
    }
}
