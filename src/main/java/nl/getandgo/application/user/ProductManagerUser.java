package nl.getandgo.application.user;

import lombok.ToString;

import javax.validation.constraints.Email;

@ToString
public class ProductManagerUser extends User{

    public ProductManagerUser(@Email String email, String password, UserType usertype, String first_name, String last_name,String phone) {
        super(email, password, usertype, first_name, last_name,phone);
        super.seed+=1;
        super.id=seed;
    }
}
