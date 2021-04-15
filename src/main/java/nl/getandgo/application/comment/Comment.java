package nl.getandgo.application.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.review.Review;
import nl.getandgo.application.user.User;


import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@ToString
@Entity(name = "Comment")
@Table(name = "comments")
public class Comment {
    /**
     * Comment Id
     * */
    @Id
    @SequenceGenerator(name = "comment_sequence", sequenceName = "comment_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "comment_sequence")
    @Column(name = "comment_id")
    @Getter @Setter private Long comment_id;

    /**
     * Review Id
     * */
    @ManyToOne
    @JoinColumn(
            name = "review_id",
            nullable = false,
            referencedColumnName = "review_id",
            foreignKey = @ForeignKey(
                    name = "review_id_fk"
            )
    )
    private Review review;

    /**
     * Commenter Id
     * */
    @ManyToOne
    @JoinColumn(
            name = "commenter_id",
            nullable = false,
            referencedColumnName = "user_id",
            foreignKey = @ForeignKey(
                    name = "user_commenter_fk"
            )
    )
    @Getter private User user;


    /**
     * Created At
     * */
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Getter @Setter private LocalDateTime createdAt;

    /**
     * Comment Content
     * */
    @Column(name = "content",nullable = false)
    @Getter @Setter private String content;



}
