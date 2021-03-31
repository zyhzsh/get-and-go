package nl.getandgo.application.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@ToString
public class Comment {
    @Getter @Setter private Long review_id;
    @Getter @Setter private Long commenter_id;
    @Getter @Setter private Date date;
    @Getter @Setter private String content;
}
