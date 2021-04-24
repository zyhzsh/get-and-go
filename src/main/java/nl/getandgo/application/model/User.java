package nl.getandgo.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@ToString
@NoArgsConstructor
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
            allocationSize = 1,
            initialValue = 10000
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
    @Column(name = "user_email",nullable = false,unique = true)
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
    @Enumerated(EnumType.STRING)
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
    @Column(name = "avatar_link")
    @Getter @Setter protected String avatar_link;

    /**
     * Phone Number
     * */
    @Column(name = "phone")
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
     * Constructor
     * @param email
     * @param password
     * @param first_name
     * @param last_name
     * @param avatar_link
     * @param phone
     * */
    public User(String email,
                String password,
                String first_name,
                String last_name,
                String avatar_link,
                String phone) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avatar_link = avatar_link;
        this.phone = phone;
        this.comments=new ArrayList<>();
    }
    /**
     * Constructor
     * @param email
     * @param password
     * @param first_name
     * @param last_name
     * */
    public User(String email,
                String password,
                String first_name,
                String last_name){
        this.email=email;
        this.password=password;
        this.first_name=first_name;
        this.last_name=last_name;
        this.comments=new ArrayList<>();
    }



    /**
     * User Type:
     * - Customer User,
     * - Manager User;
     * - Vendor User;
     * */
    public enum UserType {
        CUSTOMERUSER,
        MANAGERUSER,
        VENDORUSER
    }
}
