package nl.getandgo.application.service;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.repository.StoreRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

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
        try {
            owner_id=Long.parseLong(id);
            return storeRepository.findStoresByVendor(owner_id);
        }catch (Exception e){return null;}
    }

    public void addNewStore(Store data) {
        storeRepository.save(data);
    }

}
