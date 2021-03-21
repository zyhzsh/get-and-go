package nl.getandgo.application.user;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.comment.Comment;
import nl.getandgo.application.location.City;
import nl.getandgo.application.order.Order;
import nl.getandgo.application.review.Review;

import javax.validation.constraints.Email;
import java.util.List;

@ToString
public class CustomerUser extends User{
    @Getter @Setter private String username;
    @Getter @Setter private City city;
    @Getter @Setter private List<Review> reviews;
    @Getter @Setter private List<Order> orders;

    public CustomerUser(Long id,
                        @Email String email,
                        String password,
                        UserType usertype,
                        String first_name,
                        String last_name,
                        String avatar_link,
                        String phone,
                        List<Comment> comments,
                        String username,
                        City city,
                        List<Review> reviews,
                        List<Order> orders) {
        super(id, email, password, usertype, first_name, last_name, avatar_link, phone, comments);
        this.username = username;
        this.city = city;
        this.reviews = reviews;
        this.orders = orders;
    }
}
