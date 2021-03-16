package nl.getandgo.application.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L,"James Bond","password","sdfsdf@gmail.com"),
                new Customer(2L,"Jamila Ahmed","password","sdfsdf@gmail.com"));
    }

}
