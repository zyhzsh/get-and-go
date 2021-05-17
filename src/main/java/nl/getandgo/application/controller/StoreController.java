package nl.getandgo.application.controller;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.EditStoreDTO;
import nl.getandgo.application.dto.NewStoreDTO;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.service.StoreService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('GET_ALL_STORES')")
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
    @PreAuthorize("hasAuthority('ADD_NEW_STORE')")
    @PostMapping(value = "api/stores" )
    public void addNewStore(@RequestBody NewStoreDTO store){
        storeService.addNewStore(store);
    }

    /**
     * Edit Store Data
     */
    @PreAuthorize("hasAuthority('UPDATE_STORE_INFORMATION')")
    @PutMapping(value = "api/stores")
    public void editStoreData(@RequestBody EditStoreDTO storeDTO){
        storeService.updateStoreInFormation(storeDTO);
    }

    /**
     * Delete Store
     * */
    @PreAuthorize("hasAuthority('DELETE_STORE')")
    @DeleteMapping(value = "api/stores",params = {"id"})
    public void deleteStore(@RequestParam Long id){
        storeService.deleteStore(id);
    }

}
