package nl.getandgo.application.service;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.EditStoreDTO;
import nl.getandgo.application.dto.NewStoreDTO;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
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
        }catch (Exception e){throw new IllegalArgumentException();}
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
            }catch (Exception e){
                System.out.println(e);
            }
        });


    }

    /**
     * Updating Store Information
     * */
    public void updateStoreInFormation(EditStoreDTO storeDTO) {
        //Check Vendor Exists
        if(userRepository.findVendorById(storeDTO.getVendor_id()).isPresent()) {
            //Check Store Exists
            storeRepository.findById(storeDTO.getStore_id())
                    .ifPresent(store -> {
                store.setStore_name(storeDTO.getStore_name());
                store.setCity(storeDTO.getCity());
                store.setOfficial_website(storeDTO.getOfficial_website());
                store.setImg(storeDTO.getImg());
                store.setDescription(storeDTO.getDescription());
                storeRepository.save(store);
            });
        }
    }

    /**
     * Delete Store By Id
     * */
    public void deleteStore(Long id) {
        storeRepository.findById(id).ifPresent(store -> {
            try {
                store.getVendor().deletedStore(store);

            } catch (InstanceNotFoundException e) {
                e.printStackTrace();
            }
        }
        );
    }
}
