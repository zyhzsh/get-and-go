package nl.getandgo.application.voucher;

import lombok.*;
import nl.getandgo.application.order.Order;
import nl.getandgo.application.product.Product;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@ToString
@Entity(name = "Voucher")
@Table(name = "vouchers")
public class Voucher {
    /***
     * Voucher Id
     * */
    @Id
    @SequenceGenerator(
            name = "voucher_sequence",
            sequenceName = "voucher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "voucher_sequence"
    )
    @Column(name = "voucher_id")
    @Getter @Setter private Long voucher_id;

    /**
     * Product Id
     * */
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false,
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "product_id_fk"
            )
    )
    @Getter @Setter private Product product;

    /**
    * Price
    * */
    @Column(name = "price",nullable = false)
    @Getter @Setter private Double price;

    /**
     * Title
     * */
    @Column(name = "title",nullable = false)
    @Getter @Setter private String title;

    /**
     * Description
     * */
    @Column(name = "description",nullable = false)
    @Getter @Setter private String description;

}
