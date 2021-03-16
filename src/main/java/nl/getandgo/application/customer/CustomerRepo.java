package nl.getandgo.application.customer;

import org.springframework.stereotype.Component;

import java.util.List;

public interface CustomerRepo {
    List<Customer>  getCustomers();
}
