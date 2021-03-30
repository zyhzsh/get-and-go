package nl.getandgo.application.user;

import lombok.ToString;
import nl.getandgo.application.comment.Comment;

import javax.validation.constraints.Email;
import java.util.List;

@ToString
public class ProductManagerUser extends User{

    public ProductManagerUser(@Email String email, String password, UserType usertype, String first_name, String last_name) {
        super(email, password, usertype, first_name, last_name);
    }
}
