package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.LoginRequestDTO;
import nl.getandgo.application.dto.LoginResponseDTO;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.filter.JwtHelper;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.UserType;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final JwtHelper jwtHelper;

    //After Login Return Jwt Token
    public LoginResponseDTO Login(LoginRequestDTO loginRequestDTO)throws BadCredentialsException {
        try {
            //Find the User
            final User user = userRepository.findUserByEmail(loginRequestDTO.getEmail()).get();
            //If user not exists: user.getPassword() will fail->Catch throw Credential Error
            //If password not right : throw Credential Error
            if(!user.getPassword().equals(loginRequestDTO.getPassword())){throw new BadCredentialsException("Credential Error");}
            //Generate JWT token
            final String token=jwtHelper.generateToken(user);
            //Return ResponseDTO (@Param JWT token, @Param user_type)
            return new LoginResponseDTO(token,user.getUsertype().toString(),"login successful");
        }catch (Exception e){
            throw new BadCredentialsException("Credential Error");
        }
    }

    /**
     * Register A New Customer
     * */
    public void registerCustomerUser(NewCustomerDTO register) throws InstanceAlreadyExistsException {
        //Check Email Unique
        if(userRepository.findUserByEmail(register.getEmail()).isPresent()){ throw new InstanceAlreadyExistsException("Email address has been taken"); }
        CustomerUser newCustomer=new CustomerUser(
                register.getEmail(),
                register.getPassword(),
                register.getFirst_name(),
                register.getLast_name()
        );
        userRepository.save(newCustomer);
    }

    /**
     * Register New Vendor In System
     * */
    public void registerVendorUser(NewVendorDTO vendorDTO)throws InstanceAlreadyExistsException{
        //Check Unique Email
        if(userRepository.findUserByEmail(vendorDTO.getEmail()).isPresent()){ throw new InstanceAlreadyExistsException("Email address has been taken");  }
        //Convert DTO
        VendorUser newVendor=new VendorUser(
                vendorDTO.getEmail(),
                vendorDTO.getPassword(),
                vendorDTO.getFirst_name(),
                vendorDTO.getLast_name(),
                vendorDTO.getAvatar_link(),
                vendorDTO.getPhone());
        //Save
        userRepository.save(newVendor);
    }

    public List<User> getAllVendor() {
        return userRepository.findAllByUserType(UserType.VENDORUSER);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user= userRepository.findUserByEmail(email).orElse(null);
        if (user==null){throw new UsernameNotFoundException("User Not Found ~ ! ");}
        return user;
    }
}
