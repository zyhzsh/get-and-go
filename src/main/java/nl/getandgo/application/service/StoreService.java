package nl.getandgo.application.service;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewStoreDTO;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    /**
     * Get All Stores
     * */
    public List<Store> getAllStores() {return storeRepository.findAll(); }

    /**
     * Get Store By Id
     * */
    public Optional<Store> getStoreById(String id){
        Long store_id;
        try {
            store_id=Long.parseLong(id);
            return storeRepository.findById(store_id);
        }catch (Exception e){return null;}
    }

    /**
     * Get Store By Vendor's Id
     * */
    public List<Store> getStoresByVendorId(String id){
        Long owner_id;
        owner_id=Long.parseLong(id);
        return storeRepository.findStoresByVendor(owner_id);
    }
    /**
     * Adding New Store In System
     * */
    public void addNewStore(NewStoreDTO store) {
        //Find Vendor
        Optional<VendorUser> vendor = userRepository.findVendorById(store.getVendor_id());
        //If Vendor is exist
        vendor.ifPresent(v->{
            //Convert DTO -> Store
            Store s;
            try {
                s=new Store(
                        store.getStore_name(),
                        store.getDescription(),
                        store.getCity(),
                        store.getAddress(),
                        store.getImg(),
                        store.getOfficial_website());
                v.addStore(s);
                userRepository.save(v);
            }catch (Throwable e){
                new Exception(e.toString());
            }
        });


    }

}
