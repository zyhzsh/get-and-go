package nl.getandgo.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@ToString
@Entity(name = "Voucher")
@Table(name = "vouchers")
@AllArgsConstructor
public class Voucher {
    /***
     * Voucher Id
     * */
    @Id
    @SequenceGenerator(
            name = "voucher_sequence",
            sequenceName = "voucher_sequence",
            allocationSize = 1,
            initialValue = 10000
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
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "product_id_fk"
            )
    )
    @JsonBackReference
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

    public Voucher(Double price, String title, String description) {
        this.price = price;
        this.title = title;
        this.description = description;
    }
}
