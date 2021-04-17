package nl.getandgo.application.controller;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.User;
import nl.getandgo.application.model.dto.LoginInFoDTO;
import nl.getandgo.application.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "api/login")
    public boolean addNewProduct(@RequestBody LoginInFoDTO s){
        return true;
    }
    @GetMapping(value="api/vendors")
    public List<User> getVendorList(){
       return userService.getAllVendor();
    }
}
