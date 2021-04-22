package nl.getandgo.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@ToString
@NoArgsConstructor
@Entity(name = "CustomerUser")
@Table(name = "customer")
public class CustomerUser extends User {

    /**
     * Customer's User Name
     * */
    @Column(name = "user_name",unique = true)
    @Getter @Setter private String username;

    /**
     * Customer's City
     * */
    @Column(name = "city")
    @Getter @Setter private City city;

    /**
     * List Of Reviews
     * */
    @OneToMany(
            mappedBy = "reviewer",
            cascade = CascadeType.ALL
    )
    @Getter @Setter private List<Review> reviews;

    /**
     * List of Orders
     * */
    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL
    )
    @Getter @Setter private List<Order> orders;


    /**
     * Constructor
     * @param email
     * @param password
     * @param first_name
     * @param last_name
     * @param avatar_link
     * @param phone
     * @param username
     * @param city
     */
    public CustomerUser(String email,
                        String password,
                        String first_name,
                        String last_name,
                        String avatar_link,
                        String phone,
                        String username,
                        City city) {
        super(email, password, first_name, last_name, avatar_link, phone);
        this.username=username;
        this.city=city;
        this.reviews=new ArrayList<>();
        this.orders=new ArrayList<>();
    }
}