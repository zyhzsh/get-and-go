package nl.getandgo.application.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {
    private final StoreService storeService;
    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }
    @GetMapping("api/stores")
    public List<Store> getStores(){
        System.out.println("sss");
      return storeService.getStoreList();
    }
}
