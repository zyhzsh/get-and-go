package nl.getandgo.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthTestController {
    @GetMapping(value = "api/test/manager")
    public String manager(){
        return "manager page";
    }

    @GetMapping(value = "api/test/customer")
    public String customer(){
        return "customer page";
    }
    @GetMapping(value = "api/test/vendor")
    public String vendor(){
        return "vendor page";
    }

}
