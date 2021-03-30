package nl.getandgo.application.user;

import nl.getandgo.application.store.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<User> userList;
    public UserService(){
        userList=new ArrayList<>();
        userList.add(new CustomerUser("customer@gmail.com","customer", User.UserType.CustomerUser,"C","U"));
        userList.add(new ProductManagerUser("manager@gmail.com","manager", User.UserType.ManagerUser,"m","a"));
        userList.add(new VendorUser("vendor@gmail.com","vendor", User.UserType.VendorUser,"V","e",null));
    }

    public User Login(String email,String password){
        for (User u: userList) {
            if(u.getEmail().equals(email)&&u.getPassword().equals(password)){
                return u;
            }
        }
        return null;
    }
    public boolean registerCustomerUser(CustomerUser customerUser){
        for (User u: userList) {
            if(u.getEmail().equals(customerUser.getEmail())){
                return false;
            }
        }
        //TODO CHECK USER INPUT...
        userList.add(customerUser);


        return true;
    }
    public boolean registerVendorUser(VendorUser vendorUser, Store store){
        for (User u: userList) {
            if(u.getEmail().equals(vendorUser.getEmail())){
                return false;
            }
        }
        //TODO CHECK USER INPUT...
        userList.add(vendorUser);
        return true;
    }

}
