package nl.getandgo.application.model;

import lombok.*;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javax.persistence.GenerationType.SEQUENCE;

@ToString
@NoArgsConstructor
@Entity(name = "Order")
@Table(name = "orders")
@AllArgsConstructor
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
    @Getter private Long order_id;

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
    @ManyToOne
    @JoinColumn(
            name = "store_id",
            referencedColumnName = "store_id",
            foreignKey = @ForeignKey(
                    name = "store_id_fk"
            )
    )
    @Getter @Setter private Store store;

    /**
     * Product Id
     * */
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "product_id_fk"
            )
    )
    @Getter @Setter private Product product;

    /**
     * Voucher
     * */
    @JoinColumn(name = "voucher_id")
    @OneToOne
    @Getter private Voucher voucher;

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
    @Column(name = "buyer_email")
    @Getter private String buyer_email;

    /**
     * Detail
     * */
    @Column(name = "detail")
    @Getter @Setter private String detail;



    /**
     * @param customer
     * @param store
     * @param product
     * @param voucher
     * @param buyerEmail
     * */
    public Order(String buyerEmail,CustomerUser customer,Store store, Product product, Voucher voucher) {
        this.customer = customer;
        this.store = store;
        this.buyer_email=buyerEmail;
        this.product = product;
        this.voucher = voucher;
        this.createdAt=LocalDateTime.now();
        this.orderStatus=OrderStatus.PROCESSING;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.detail="User: "+customer.getFirst_name()+" "+customer.getLast_name()+" Email: "+customer.getEmail()+" On "+createdAt.format(formatter)+" Ordered: "
                +voucher.getTitle()+" "+voucher.getDescription();
    }

    /**
     * Order Status
     * */
    @Enumerated(EnumType.STRING)
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
        CANCELED,
        WAITINGFORPAY,
        PROCESSING,
        COMPLETED
    }
}
