package nl.getandgo.application.controller;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.model.User;
import nl.getandgo.application.dto.LoginDetailDTO;
import nl.getandgo.application.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "api/login")
    public boolean addNewProduct(@RequestBody LoginDetailDTO s){
        return true;
    }

    /**
     * Get Vendor List
     * */
    @GetMapping(value="api/vendors")
    public List<User> getVendorList(){
       return userService.getAllVendor();
    }

    /**
     * SignUp A new Vendor
     * */
    @PostMapping(value = "api/vendor/signup")
    public String signUpVendor(@RequestBody NewVendorDTO vendorDTO){
         try{
             userService.registerVendorUser(vendorDTO);
         }catch (InstanceAlreadyExistsException e){
             return e.getMessage();
         }
         return "Request Accepted";
    }

    /**
     * SignUp A New Customer User
     * */
    @PostMapping(value = "api/customer/signup")
    public String signUpCustomer(@RequestBody NewCustomerDTO customerDTO)  {
        try{
            userService.registerCustomerUser(customerDTO);
        } catch (InstanceAlreadyExistsException e) {
           return e.getMessage();
        }
        return "Request Accepted";
    }
}
