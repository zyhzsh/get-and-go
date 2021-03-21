package nl.getandgo.application.user;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.comment.Comment;

import javax.validation.constraints.Email;
import java.util.List;

@ToString
@AllArgsConstructor
public abstract class User {

    @Getter private Long id;
    @Getter private @Email String email;
    @Getter @Setter private String password;
    @Getter @Setter private UserType usertype;
    @Getter @Setter private String first_name;
    @Getter @Setter private String last_name;
    @Getter @Setter private String avatar_link;
    @Getter @Setter private String phone;

    @Getter @Setter private List<Comment> comments;
    enum UserType {
        CustomerUser, ManagerUser, VendorUser
    }
}
