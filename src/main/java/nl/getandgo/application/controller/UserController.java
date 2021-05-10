package nl.getandgo.application.controller;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.LoginRequestDTO;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.filter.JwtHelper;
import nl.getandgo.application.model.User;
import nl.getandgo.application.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * User Login
    * */
    @PostMapping(value = "api/login")
    public String login(@RequestBody LoginRequestDTO loginUser){
        try{
            return  userService.Login(loginUser);
        }catch (BadCredentialsException e){
            return "e";
        }
    }


    @GetMapping(value = "api/confirm")
    public ModelAndView confirm(@RequestParam("token") String token){
        boolean result=userService.activateUserByToken(token);
        if(result) { return new ModelAndView("redirect:"+"http://localhost:8080/"); }
        return new  ModelAndView("Errors:+"+"http://localhost:8080/Error");
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
        System.out.println(vendorDTO.getEmail());
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
