package nl.getandgo.application.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.comment.Comment;


//import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@ToString
public abstract class User {
   // @Id
    @Getter private Long id;
    @Getter private @Email String email;
    @Getter @Setter private String password;
    @Getter @Setter private UserType usertype;
    @Getter @Setter private String first_name;
    @Getter @Setter private String last_name;
    @Getter @Setter private String avatar_link;
    @Getter @Setter private String phone;
    @Getter private List<Comment> comments;
    public User(@Email String email, String password, UserType usertype, String first_name, String last_name) {
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.first_name = first_name;
        this.last_name = last_name;
        comments=new ArrayList<>();
    }


    //Comment
    public void addComment(Comment comment){
        comments.add(comment);
    }


    enum UserType {
        CustomerUser, ManagerUser, VendorUser
    }
}
