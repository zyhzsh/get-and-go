package UnitTests.Controllers;

import com.github.javafaker.Faker;
import nl.getandgo.application.controller.StoreController;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.service.StoreService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StoreControllerTest {
    @InjectMocks
    StoreController storeController;
    @Mock
    StoreService storeService;
    private static Faker faker;
    @BeforeClass
    public static void setUp(){
        faker=new Faker();
    }
    @Test
    public void testGetAllStores(){
        //Arrange
        List<Store> stores=new ArrayList<>();
        stores.add(new Store());
        stores.add(new Store());
        stores.add(new Store());
        stores.add(new Store());
        //Act
        when(storeService.getAllStores()).thenReturn(stores);
        List<Store> result=storeController.getAllStores();

        Assert.assertArrayEquals(stores.toArray(),result.toArray());
    }
}
