package nl.getandgo.application.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@ToString
@Entity(name = "CustomerUser")
@Table(name = "customer")
public class CustomerUser extends User {

    /**
     * Customer's User Name
     * */
    @Column(name = "user_name",unique = true,nullable = false)
    @Getter @Setter private String username;

    /**
     * Customer's City
     * */
    @Column(name = "city",nullable = false)
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


}
