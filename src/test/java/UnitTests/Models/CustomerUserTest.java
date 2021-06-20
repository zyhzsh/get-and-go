package UnitTests.Models;

import com.github.javafaker.Faker;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerUserTest {

    private static Faker faker;
    @BeforeAll
    public static void Setup(){
        faker=new Faker();
    }


    @Test
    public void CustomerRegisterTest(){
       //Arrange
        String email= faker.internet().emailAddress();
        String password="ttttttt";
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();

        //Act
        CustomerUser customerUser_1=new CustomerUser(
                email,
                password,
                firstname,
                lastname);

        //Assert
        assertEquals(false,customerUser_1.isEnabled());
        assertEquals(email,customerUser_1.getEmail());
        assertEquals(password,customerUser_1.getPassword());
        assertEquals(firstname,customerUser_1.getFirst_name());
        assertEquals(lastname,customerUser_1.getLast_name());
        assertEquals(true,customerUser_1.getReviews().isEmpty());
        assertEquals(true,customerUser_1.getOrders().isEmpty());
        assertEquals(null,customerUser_1.getCity());
        assertEquals(null,customerUser_1.getUsername());
    }

    @Test
    public void CustomerPlaceAnOderTest(){
        //Arrange customer
        String email= faker.internet().emailAddress();
        String password="ttttttt";
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();
        CustomerUser customerUser=new CustomerUser(email, password, firstname, lastname);
        Order order=mock(Order.class);
        //Act
        customerUser.addOrder(order);
        //Assert
        //System.out.println(customerUser_1.getUser_id());
        assertEquals(1,customerUser.getOrders().stream().count());
    }

}
