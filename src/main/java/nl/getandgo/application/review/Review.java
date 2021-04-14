package nl.getandgo.application.review;
import lombok.*;
import nl.getandgo.application.comment.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    @Column(name = "product_id",nullable = false)
    @Getter @Setter private Long product_id;

    /**
     * Reviewer_id
     * */
    @Column(name = "reviewer_id",nullable = false)
    @Getter @Setter private Long reviewer_id;

    /**
     * List of comment below the Review
     * */
//    @OneToMany
//    @Getter @Setter private List<Comment> comments;

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
