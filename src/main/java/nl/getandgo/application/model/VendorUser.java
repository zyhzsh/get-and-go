package nl.getandgo.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.management.InstanceAlreadyExistsException;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@ToString
@NoArgsConstructor
@Entity(name = "VendorUser")
@Table(name = "vendors")
public class VendorUser extends User {

    @OneToMany(
            mappedBy = "vendor",
            cascade = CascadeType.MERGE
    )
    @JsonBackReference
    @Getter @Setter private List<Store> storeList;

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
        this.storeList=new ArrayList<>();
    }

    public void addStore(Store store) throws InstanceAlreadyExistsException {
        if(!storeList.contains(store)){
            storeList.add(store);
            store.setVendor(this);
        }else {
            throw new InstanceAlreadyExistsException();
        }
    }
}
