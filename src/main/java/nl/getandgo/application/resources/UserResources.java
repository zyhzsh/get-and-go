package nl.getandgo.application.resources;

import nl.getandgo.application.DTO.User;
import nl.getandgo.application.FakeDataStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResources {

    private static final FakeDataStore Data=new FakeDataStore();
    @PostMapping(value = "api/user")
    public Object addNewProduct(@RequestBody User user){
        User temp =Data.Login(user);
        System.out.println(user.getUsername());
        if(temp!=null){
            return temp;
        }
        else {
            return user;
        }
    }
}
