package nl.getandgo.application.user;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @PostMapping(value = "api/login")
    public boolean addNewProduct(@RequestBody LoginInFoDTO s){
        System.out.println(s.getEmail());
        return true;
    }
    @GetMapping(value="api/vendors")
    public List<VendorUser> getVendorList(){
        System.out.println("get Vendor List list");
        return null;
    }
}
