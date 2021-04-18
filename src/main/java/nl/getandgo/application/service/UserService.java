package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public boolean registerVendorUser(VendorUser vendorUser, Store store){
        return true;
    }

    public List<User> getAllVendor() {
        return userRepository.findAll();
    }
}
