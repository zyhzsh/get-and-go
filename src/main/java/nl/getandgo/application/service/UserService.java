package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StoreRepository storeRepository;

    public User Login(String email,String password){
        return null;
    }

    public boolean registerCustomerUser(CustomerUser customerUser){
        return true;
    }

    /**
     * Register New Vendor In System
     * */
    public boolean registerVendorUser(NewVendorDTO vendorDTO){
        //Check Unique Email
        if(userRepository.findUserByEmail(vendorDTO.getEmail()).isPresent()){ return false;}
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
        return true;
    }

    public List<User> getAllVendor() {
        return userRepository.findAll();
    }
}
