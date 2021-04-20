package nl.getandgo.application.controller;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewStoreDTO;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    /**
     * Get All Store
     * */
    @GetMapping("api/stores")
    public List<Store> getAllStores(){
      return storeService.getAllStores();
    }

    /**
     * Get Store By Id
     * */
    @GetMapping(value = "api/store",params = {"id"})
    public Optional<Store> getStoreByStoreId(@RequestParam String id){
        return storeService.getStoreById(id);
    }

    /**
     * Add New Store
     * */
    @PostMapping(value = "api/stores" )
    public void addNewStore(@RequestBody NewStoreDTO store){
        storeService.addNewStore(store);
    }


}
