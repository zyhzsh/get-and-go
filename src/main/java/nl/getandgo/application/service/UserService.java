package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.LoginRequestDTO;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.filter.JwtHelper;
import nl.getandgo.application.model.ConfirmationToken;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.ConfirmationTokenRepository;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final JwtHelper jwtHelper;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailService emailService;

    //After Login Return Jwt Token
    public String Login(LoginRequestDTO loginRequestDTO)throws BadCredentialsException {
        final UserDetails user = userRepository.findUserByEmail(loginRequestDTO.getEmail()).orElse(null);
        if(user==null){throw new BadCredentialsException("user not exists");}
        final String jwt=jwtHelper.generateToken(user);
        return jwt;
    }

    /**
     * Register A New Customer
     * */
    public void registerCustomerUser(NewCustomerDTO register) throws InstanceAlreadyExistsException {
        //Check Email Unique
        User user=userRepository.findUserByEmail(register.getEmail()).orElse(null);
        //When Email Address is exist
        if(user!=null){
            //When The Email is not enabled, then created token and send Active Email again
            if(!user.isEnabled()){
                //Generate token
                GenerateActivateEmailForUser(user);
                return;
            }else {
                //If the email already enabled which means the Email already been used by a customer;
                throw new InstanceAlreadyExistsException("Email address has been taken");
            }
        }
        CustomerUser newCustomer=new CustomerUser(
                register.getEmail(),
                register.getPassword(),
                register.getFirst_name(),
                register.getLast_name()
        );
        userRepository.save(newCustomer);
        GenerateActivateEmailForUser(newCustomer);
    }

    /**
     * Generate Active Link For User
     * */
    private void GenerateActivateEmailForUser(User user){
        String token= UUID.randomUUID().toString();
        ConfirmationToken confirmationToken=new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),//Expire Time 10 minus
                user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //send token to the email;
        String emailBody= emailService.buildEmailBody(user.getLast_name()+" "+user.getFirst_name(),token);
        emailService.send(user.getEmail(),emailBody);
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
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user= userRepository.findUserByEmail(email).orElse(null);
        if (user==null){throw new UsernameNotFoundException("User Not Found ~ ! ");}
        return user;
    }


    public boolean activateUserByToken(String token) {
        //Find Token
        ConfirmationToken confirmationToken=confirmationTokenService.findToken(token).orElse(null);
        //Verify Token Exist or not
        if (confirmationToken!=null
                //Check Expired or not
                && confirmationToken.getExpiresAt().isBefore(LocalDateTime.now())){
            //Confirm Activate Time
            confirmationToken.setConfirmedAt(LocalDateTime.now());

            //Enable User
            confirmationToken.getUser().setEnabled(true);

            //Update Token
            confirmationTokenService.saveConfirmationToken(confirmationToken);
            return true;
        }
        return false;

    }
}
