package nl.getandgo.application.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


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
    @Column(name = "review_id",nullable = false)
    @Getter @Setter private Long review_id;

    /**
     * Commenter Id
     * */
//    @Column(name = "commter_id")
//    @Getter @Setter private User commenter_id;

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
