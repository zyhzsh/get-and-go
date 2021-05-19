package UnitTests.Serivices;

import com.github.javafaker.Faker;
import nl.getandgo.application.dto.EditStoreDTO;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import nl.getandgo.application.service.StoreService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.management.InstanceAlreadyExistsException;
import java.util.Optional;

public class StoreServiceTest {
    private Faker faker;
    @InjectMocks
    private StoreService storeService;
    @Mock
    private StoreRepository storeRepository;
    @Mock
    private UserRepository userRepository;

    @Before
    public void Setup(){
        faker=new Faker();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void Deleted_Exist_Store_Test(){
        //Arrange
        String store_name=faker.company().name();
        String description=faker.lorem().characters(50);
        City city= City.EINDOHOVEN;
        String address=faker.address().streetAddress();
        String img=faker.internet().image();
        String website=faker.internet().domainName();

        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        String avatar_link=faker.internet().avatar();
        String phone=faker.phoneNumber().phoneNumber();
        Store store=new Store(store_name,description,city,address,img,website);
        VendorUser vendor=new VendorUser(email,password,first_name,last_name,avatar_link,phone);
        store.setVendor(vendor);
        //Act
        Mockito.when(storeRepository.findById(store.getStore_id())).thenReturn(Optional.of(store));


        storeService.deleteStore(store.getStore_id());
    }

    @Test
    public void Deleted_Non_Exist_Store_Test(){
        Long store_id=1111L;
        //Act
        Mockito.when(storeRepository.findById(store_id)).thenReturn(Optional.empty());
        storeService.deleteStore(store_id);

    }

    @Test
    public void Update_Store_When_Vendor_Is_Not_Exist_Test(){
        //Arrange
        Long vendor_id=faker.number().numberBetween(100L,2000L);
        Long store_id=faker.number().numberBetween(100L,2000L);
        String store_name=faker.company().name();
        City city= City.EINDOHOVEN;
        String description=faker.lorem().characters(50);
        String address=faker.address().streetAddress();
        String img=faker.internet().image();
        String website=faker.internet().domainName();
        EditStoreDTO editStoreDTO=new EditStoreDTO(vendor_id,store_name,city,website,address,img,description,store_id);
        //Act
        Mockito.when(userRepository.findVendorById(vendor_id)).thenReturn(Optional.empty());
        storeService.updateStoreInFormation(editStoreDTO);
    }

    @Test
    public void Update_Store_When_Store_Is_Not_Exist_Test() throws InstanceAlreadyExistsException {
        //Arrange
        Long vendor_id=faker.number().numberBetween(100L,2000L);
        Long store_id=faker.number().numberBetween(100L,2000L);
        String store_name=faker.company().name();
        City city= City.EINDOHOVEN;
        String description=faker.lorem().characters(50);
        String address=faker.address().streetAddress();
        String img=faker.internet().image();
        String website=faker.internet().domainName();
        EditStoreDTO editStoreDTO=new EditStoreDTO(vendor_id,store_name,city,website,address,img,description,store_id);

        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        String avatar_link=faker.internet().avatar();
        String phone=faker.phoneNumber().phoneNumber();

        Store store=new Store(store_name,description,city,address,img,website);
        VendorUser vendor=new VendorUser(email,password,first_name,last_name,avatar_link,phone);
        vendor.addStore(store);

        //Act
        Mockito.when(userRepository.findVendorById(vendor_id)).thenReturn(Optional.of(vendor));
        Mockito.when(storeRepository.findById(vendor_id)).thenReturn(Optional.empty());
        storeService.updateStoreInFormation(editStoreDTO);

    }



}
