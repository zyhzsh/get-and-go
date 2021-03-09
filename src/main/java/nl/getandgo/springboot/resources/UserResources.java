package nl.getandgo.springboot.resources;

import nl.getandgo.springboot.DTO.User;
import nl.getandgo.springboot.FakeDataStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResources {

    private static final FakeDataStore Data=new FakeDataStore();

    @PostMapping(value = "api/user")
    public Object addNewProduct(@RequestBody User user){
        User temp =Data.Login(user);
        System.out.printf(user.getUsername());
        if(temp!=null){
            return temp;
        }
        else {
            return user;
        }
    }
}
