package nl.getandgo.application.user;

import lombok.ToString;
import nl.getandgo.application.comment.Comment;

import javax.validation.constraints.Email;
import java.util.List;

@ToString
public class ProductManagerUser extends User{
    public ProductManagerUser(Long id,
                              @Email String email,
                              String password,
                              UserType usertype,
                              String first_name,
                              String last_name,
                              String avatar_link,
                              String phone,
                              List<Comment> comments) {
        super(id, email, password, usertype, first_name, last_name, avatar_link, phone, comments);
    }
}
