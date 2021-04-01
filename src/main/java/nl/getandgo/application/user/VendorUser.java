package nl.getandgo.application.user;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.store.Store;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@ToString
public class VendorUser extends User{
    @Getter @Setter private List<Store> storeList;

    public VendorUser(@Email String email, String password, UserType usertype, String first_name, String last_name,Store store,String phone) {
        super(email, password, usertype, first_name, last_name,phone);
        super.seed+=1;
        super.id=seed;
        storeList=new ArrayList<>();
        storeList.add(store);
    }
    public void addStore(Store store) {
        storeList.add(store);
    }
}
