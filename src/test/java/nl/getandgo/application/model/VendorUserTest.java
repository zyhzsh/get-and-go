package nl.getandgo.application.model;

import com.github.javafaker.Faker;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.VendorUser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.management.InstanceAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class VendorUserTest {

    private static Faker faker;
    @BeforeClass
    public static void Setup(){
        faker=new Faker();
    }

    @Test
    public void VendorUserUniqueSequenceIdTest(){
        //Arrange
        VendorUser vendorUser_1=new VendorUser(
                faker.internet().emailAddress(),
                faker.lorem().characters(15),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().avatar(),
                faker.phoneNumber().cellPhone()
        );
        VendorUser vendorUser_2=new VendorUser(
                faker.internet().emailAddress(),
                faker.lorem().characters(15),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().avatar(),
                faker.phoneNumber().cellPhone());
        //Act
        Long id_1=vendorUser_1.getUser_id();
        Long id_2=vendorUser_2.getUser_id();

        String x=faker.commerce().color();
        //Assert
        assertEquals(vendorUser_1.getStoreList(),vendorUser_2.getStoreList());

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
        Assert.assertTrue(vendorUser_1.getStoreList().contains(store_1));
    }

    @Test(expected =InstanceAlreadyExistsException.class )
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
        vendorUser_1.addStore(store_1);
        //Assert
        Assert.assertTrue(vendorUser_1.getStoreList().contains(store_1));
    }

}
