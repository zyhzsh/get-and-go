package nl.getandgo.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@Entity(name = "VendorUser")
@Table(name = "vendors")
public class VendorUser extends User {

    @OneToMany(
            mappedBy = "vendor",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JsonBackReference
    @Getter @Setter private List<Store> storeList=new ArrayList<>();
    /**
     * Constructor
     * @param email
     * @param password
     * @param first_name
     * @param last_name
     * @param avatar_link
     * @param phone
     */
    public VendorUser(String email,
                      String password,
                      String first_name,
                      String last_name,
                      String avatar_link,
                      String phone) {
        super(email, password, first_name, last_name, avatar_link, phone);
        this.usertype=UserType.VENDORUSER;
    }
    /**
     * Adding New Store
     * */
    public void addStore(Store store) throws InstanceAlreadyExistsException {
        if(!storeList.contains(store)){
            storeList.add(store);
            store.setVendor(this);
        }else {
            throw new InstanceAlreadyExistsException();
        }
    }
    /**
     * Remove the Store Belong to this Owner:
     * - Remove The Store
     * - Close the Store ( Decouple: the Relationship Between Store and Vendor... )
     * */
    public void deleteStore(Store store) throws InstanceNotFoundException{
        if(!storeList.contains(store)){throw new InstanceNotFoundException();}
        storeList.remove(store);
        store.CloseStore();
    }
}
