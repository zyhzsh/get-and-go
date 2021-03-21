package nl.getandgo.application.user;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.comment.Comment;
import nl.getandgo.application.store.Store;
import javax.validation.constraints.Email;
import java.util.List;

@ToString
public class VendorUser extends User{
    @Getter @Setter private List<Store> storeList;
    public VendorUser(Long id,
                      @Email String email,
                      String password,
                      UserType usertype,
                      String first_name,
                      String last_name,
                      String avatar_link,
                      String phone,
                      List<Comment> comments,
                      List<Store> storeList) {
        super(id, email, password, usertype, first_name, last_name, avatar_link, phone, comments);
        this.storeList = storeList;
    }
}
