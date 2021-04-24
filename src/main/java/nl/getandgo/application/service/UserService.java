package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public User Login(String email,String password){
        return null;
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
        return userRepository.findAll();
    }
}
