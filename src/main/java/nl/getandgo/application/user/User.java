package nl.getandgo.application.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.comment.Comment;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@ToString
@Entity(name = "User")
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User {

    /**
     * User Id
     * */
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "users_sequence"
    )
    @Column(name = "user_id")
    @Getter @Setter private Long user_id;

    /**
     * User Email
     * */
    @Column(name = "user_email",nullable = false)
    @Getter @Setter protected String email;

    /**
     * User Password
     * */
    @JsonIgnore
    @Column(name = "password",nullable = false)
    @Getter @Setter protected String password;

    /**
     * User Type
     * */
    @Column(name = "user_type",nullable = false)
    @Getter @Setter protected UserType usertype;


    /**
     * First Name
    * */
    @Column(name = "first_name",nullable = false)
    @Getter @Setter protected String first_name;

    /**
     * Last Name
     * */
    @Column(name = "last_name",nullable = false)
    @Getter @Setter protected String last_name;
    /**
     * Avatar Link
     * */
    @Column(name = "avatar_link",nullable = false)
    @Getter @Setter protected String avatar_link;

    /**
     * Phone Number
     * */
    @Column(name = "phone",nullable = false)
    @Getter @Setter protected String phone;

    /**
     * List Of Comment
     * */
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @Getter @Setter protected List<Comment> comments;


    /**
     * User Type:
     * - Customer User,
     * - Manager User;
     * - Vendor User;
     * */
    enum UserType {
        CustomerUser, ManagerUser, VendorUser
    }
}
