package nl.getandgo.application.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.comment.Comment;


import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
   // @Id
    protected static Long seed=100000L;
    @Getter protected Long id;
    @Getter protected @Email String email;
    @JsonIgnore
    @Getter @Setter protected String password;
    @Getter @Setter protected UserType usertype;
    @Getter @Setter protected String first_name;
    @Getter @Setter protected String last_name;
    @Getter @Setter protected String avatar_link;
    @Getter @Setter protected String phone;
    @Getter protected List<Comment> comments;
    public User(@Email String email, String password, UserType usertype, String first_name, String last_name,String phone) {
        this.seed+=1;
        this.id=seed;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone=phone;
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
