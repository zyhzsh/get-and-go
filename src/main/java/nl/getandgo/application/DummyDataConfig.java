package nl.getandgo.application;
import com.github.javafaker.Faker;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyDataConfig {
    @Bean
    CommandLineRunner commandLineRunner(StoreRepository storeRepository, UserRepository userRepository) {

        return args -> {
            AddProducts(City.EINDOHOVEN,5, Product.Category.FOOD,storeRepository,userRepository);
            AddProducts(City.EINDOHOVEN,10, Product.Category.WELLNESS,storeRepository,userRepository);
            AddProducts(City.EINDOHOVEN,15, Product.Category.SPECIALITY,storeRepository,userRepository);
            AddProducts(City.BREDA,15, Product.Category.EVENT,storeRepository,userRepository);
            AddProducts(City.HAARLEM,15, Product.Category.EVENT,storeRepository,userRepository);
            AddProducts(City.DELFT,15, Product.Category.EVENT,storeRepository,userRepository);
            AddProducts(City.UTRECHT,15, Product.Category.EVENT,storeRepository,userRepository);
        };
    }
    private void AddProducts(City city, int num, Product.Category category,StoreRepository storeRepository,UserRepository userRepository){
        Faker faker=new Faker();
        VendorUser vendor=new VendorUser(
                faker.internet().emailAddress(),
                faker.lorem().characters(8),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().avatar(),
                faker.phoneNumber().cellPhone());
        for (int i=0;i<num;i++){
            Store s1=new Store(
                    faker.company().name(),
                    faker.lorem().characters(50),
                    city,
                    faker.address().streetAddress(),
                    "https://picsum.photos/640/360",
                    faker.company().url()
            );
            Product p1 = new Product(
                    null,
                    faker.commerce().productName(),
                    faker.number().numberBetween(1,99999),
                    faker.number().numberBetween(1,99999),
                    faker.number().numberBetween(20,1000),
                    Product.Status.ONSALE,
                    faker.company().buzzword(),
                    "https://picsum.photos/640/360",
                    category,
                    null);
            s1.AddProduct(p1);
            vendor.addStore(s1);
            userRepository.save(vendor);
           // storeRepository.save(s1);
        }

    }
}
