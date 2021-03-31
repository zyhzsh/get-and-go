package nl.getandgo.application.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StoreController {
    private final StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @GetMapping("api/stores")
    public List<Store> getStores(){
        System.out.println("Stores");
      return storeService.getStoreList();
    }
//    @PostMapping(value = "api/stores" @params = "Owner")
//    public boolean addNewStore(@RequestBody Store store){
//
//    }
}
