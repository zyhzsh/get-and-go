package nl.getandgo.application.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "api/login")
    public boolean addNewProduct(@RequestBody LoginInFoDTO s){
        System.out.println(s.getEmail());
        return true;
    }
    @GetMapping(value="api/vendors")
    public List<User> getVendorList(){
        System.out.println("get Vendor List list");
       return userService.getAllVendor();
    }
}
