package nl.getandgo.application.user;
import org.springframework.web.bind.annotation.*;
@RestController
public class UserController {


    @PostMapping(value = "api/login")
    public boolean addNewProduct(@RequestBody LoginInFoDTO s){
        System.out.println(s.getEmail());
        return true;
    }

}
