package UnitTests.Models;

import com.github.javafaker.Faker;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.VendorUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;


public class VendorUserTest {

    private static Faker faker;
    @BeforeAll
    public static void Setup(){
        faker=new Faker();
    }

    @Test
    public void AddVendorUserTest(){
        //Arrange
        String email= faker.internet().emailAddress();
        String password =faker.lorem().characters(15);
        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();
        String avatar=faker.internet().avatar();
        String phone=faker.phoneNumber().cellPhone();

        //Act
        VendorUser vendorUser_1=new VendorUser(
                email,
                password,
                firstname,
                lastname,
                avatar,
                phone
        );
        //Assert
        assertEquals(true,vendorUser_1.isEnabled());
        assertEquals(email,vendorUser_1.getEmail());
        assertEquals(password,vendorUser_1.getPassword());
        assertEquals(firstname,vendorUser_1.getFirst_name());
        assertEquals(lastname,vendorUser_1.getLast_name());
        assertEquals(phone,vendorUser_1.getPhone());
    }

    @Test
    public void VendorUserAddStoreTest() throws InstanceAlreadyExistsException {
        //Arrange
        VendorUser vendorUser_1=new VendorUser(
                faker.internet().emailAddress(),
                faker.lorem().characters(15),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().avatar(),
                faker.phoneNumber().cellPhone()
        );
        Store store_1=new Store(
                faker.company().name(),
                faker.lorem().characters(50),
                City.EINDOHOVEN,
                faker.address().streetAddress(),
                "https://picsum.photos/640/360",
                faker.company().url()
        );

        //Act
        vendorUser_1.addStore(store_1);
        //Assert
        assertEquals(true,vendorUser_1.getStoreList().contains(store_1));

    }

    @Test
    public void VendorUserDeleteStoreTest() throws InstanceAlreadyExistsException, InstanceNotFoundException {
        //Arrange
        VendorUser vendorUser_1=new VendorUser(
                faker.internet().emailAddress(),
                faker.lorem().characters(15),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().avatar(),
                faker.phoneNumber().cellPhone()
        );
        Store store_1=mock(Store.class);
        Store store_2=mock(Store.class);
        Store store_3=mock(Store.class);
        vendorUser_1.addStore(store_1);
        vendorUser_1.addStore(store_2);
        vendorUser_1.addStore(store_3);
        //Act
        vendorUser_1.deleteStore(store_1);
        //Assert
        assertEquals(false,vendorUser_1.getStoreList().contains(store_1));

    }

    @Test
    public void VendorUserAddDuplicateStoreTest() throws InstanceAlreadyExistsException {
        //Arrange
        VendorUser vendorUser_1=new VendorUser(
                faker.internet().emailAddress(),
                faker.lorem().characters(15),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().avatar(),
                faker.phoneNumber().cellPhone()
        );
        Store store_1=new Store(
                faker.company().name(),
                faker.lorem().characters(50),
                City.EINDOHOVEN,
                faker.address().streetAddress(),
                "https://picsum.photos/640/360",
                faker.company().url()
        );
        //Act
        vendorUser_1.addStore(store_1);
        //Assert
        Assertions.assertThrows(InstanceAlreadyExistsException.class,()->{
            vendorUser_1.addStore(store_1);
        });

    }


}
