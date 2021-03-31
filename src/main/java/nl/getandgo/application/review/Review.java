package nl.getandgo.application.review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.comment.Comment;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@ToString
public class Review {
    @Getter @Setter private Long review_id;
    @Getter @Setter private Long product_id;
    @Getter @Setter private Long reviewer_id;
    @Getter @Setter private List<Comment> comments;
    @Getter @Setter private Date date;
    @Getter @Setter private String content;
    @Getter @Setter private double rating;
}
