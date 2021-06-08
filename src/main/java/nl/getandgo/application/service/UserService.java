package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.*;
import nl.getandgo.application.Util.JwtHelper;
import nl.getandgo.application.model.*;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;
    private final JwtHelper jwtHelper;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailService emailService;
    private final BCryptPasswordEncoder passwordEncoder;


    //After Login Return Jwt Token
    public LoginResponseDTO Login(LoginRequestDTO loginRequestDTO)  {
        String msg="Error";
        try {
            //Find the User
            final User user = userRepository.findUserByEmail(loginRequestDTO.getEmail()).orElse(null);
            if (user!=null){
                //If the user not been Activated
                if(!user.isEnabled()){return new LoginResponseDTO("","","User Need to be Activated ~! ",null);}
                //If password not right
                if(!passwordEncoder.matches(loginRequestDTO.getPassword(),user.getPassword())){ return new LoginResponseDTO("","","E-mail does not exists or the password is wrong",null); }

                //Generate JWT token
                final String token=jwtHelper.generateToken(user);
                //Return ResponseDTO (@Param JWT token, @Param user_type)
                UserProfileDTO userProfileDTO=new UserProfileDTO(user.getUser_id(),user.getEmail(),user.getFirst_name(),user.getLast_name(),user.getAvatar_link(),user.getPhone());
                return new LoginResponseDTO(token,user.getUsertype().toString(),"login successful",userProfileDTO);
            }
        }catch (Exception e){
            return new LoginResponseDTO("","","E-mail does not exists or the password is wrong",null);
        }
        return new LoginResponseDTO("","",msg,null);
    }
    /**
     * Register A New Customer
     * */
    @Async
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
                passwordEncoder.encode(register.getPassword()),
                register.getFirst_name(),
                register.getLast_name()
        );
        userRepository.save(newCustomer);
        GenerateActivateEmailForUser(newCustomer);
    }

    /**
     * Generate Active Link For User
     * */
    @Async
    public void GenerateActivateEmailForUser(User user){
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
                passwordEncoder.encode(vendorDTO.getPassword()),
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

    public boolean activateUserByToken(String token) {
        //Find Token
        ConfirmationToken confirmationToken=confirmationTokenService.findToken(token);
        //Verify Token Exist or not
        if (confirmationToken!=null
                //Check Expired or not
                && confirmationToken.getExpiresAt().isAfter(LocalDateTime.now())){
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
