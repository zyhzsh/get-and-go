package nl.getandgo.application.customer;

import nl.getandgo.application.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path="api/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    CustomerController( CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
       return customerService.getCustomers();
    }

    @PostMapping
    void createNewCustomer(@RequestBody @Valid Customer customer){
        System.out.println("Post..");
        System.out.println(customer);
    }
    @GetMapping(path = "/exception",params = "id")
    Customer getCustomerException(Long id){
        throw new ApiRequestException(
          "ApiRequestException for customer "+ id);
    }
    @GetMapping(params = "id")
    Customer getCustomer(Long id){
          return customerService.getCustomer(id);
    }
}
