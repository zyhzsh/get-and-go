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
        userList.add(new CustomerUser("customer@gmail.com","customer", User.UserType.CustomerUser,"C","U","064345876"));
        userList.add(new ProductManagerUser("manager@gmail.com","manager", User.UserType.ManagerUser,"m","a","06879564125"));
        userList.add(new VendorUser("vendorA@gmail.com","vendor", User.UserType.VendorUser,"Vendor A","aa",null,"0665987125"));
        userList.add(new VendorUser("vendorB@gmail.com","vendor", User.UserType.VendorUser,"Vendor B","bb",null,"0685459475"));
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

    public List<User> getAllVendor() {
        List<User> temp=new ArrayList<>();
        for (User u: userList){
            if(u instanceof VendorUser){
                temp.add(u);
            }
        }
        return temp;
    }
}
