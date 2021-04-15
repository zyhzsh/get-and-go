package nl.getandgo.application.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.store.Store;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@ToString
@NoArgsConstructor
@Entity(name = "VendorUser")
@Table(name = "vendors")
public class VendorUser extends User{
    @OneToMany(
            mappedBy = "vendor",
            cascade = CascadeType.ALL
    )
    @Getter @Setter private List<Store> storeList;
}
