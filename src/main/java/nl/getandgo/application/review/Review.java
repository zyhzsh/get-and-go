package nl.getandgo.application.review;
import lombok.*;
import nl.getandgo.application.comment.Comment;
import nl.getandgo.application.product.Product;
import nl.getandgo.application.user.CustomerUser;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@ToString
@Entity(name = "Review")
@Table(name = "reviews")
public class Review {

    /**
     * Review Id
     * */
    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "review_sequence"
    )
    @Column(name = "review_id")
    @Getter @Setter private Long review_id;

    /**
     * Product Id
     * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "product_id",
            nullable = false,
            referencedColumnName = "product_id",
            foreignKey = @ForeignKey(
                    name = "product_id_fk"
            )
    )
    @Getter private Product product;

    /**
     * Reviewer_id
     * */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "reviewer_id",
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    @Getter @Setter private CustomerUser reviewer;

    /**
     * List of comment below the Review
     * */
    @OneToMany(
            mappedBy = "review",
            orphanRemoval = true,
        cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @Getter @Setter private List<Comment> comments;

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
     * Review's Content
     * */
    @Column(name = "content",nullable = false)
    @Getter @Setter private String content;

    /**
     * Rating
     * */
    @Column(name = "rating")
    @Getter @Setter private double rating;

}
