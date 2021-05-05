package nl.getandgo.application.controller;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.LoginRequestDTO;
import nl.getandgo.application.dto.LoginResponseDTO;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.filter.JwtHelper;
import nl.getandgo.application.model.User;
import nl.getandgo.application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    @PostMapping(value = "api/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginUser) throws Exception{
        System.out.println(loginUser.getEmail());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userService
                .loadUserByUsername(loginUser.getEmail());
        final String jwt=jwtHelper.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponseDTO(jwt));
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
