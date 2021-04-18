package nl.getandgo.application.model;

import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@NoArgsConstructor
@Entity(name = "ProductManagerUser")
@Table(name = "managers")
public class ProductManagerUser extends User {

    /**
     * Constructor
     * @param email
     * @param password
     * @param first_name
     * @param last_name
     * @param avatar_link
     * @param phone
     */
    public ProductManagerUser(String email,
                              String password,
                              String first_name,
                              String last_name,
                              String avatar_link,
                              String phone) {
        super(email, password, first_name, last_name, avatar_link, phone);
        this.usertype=UserType.MANAGERUSER;
    }

}
