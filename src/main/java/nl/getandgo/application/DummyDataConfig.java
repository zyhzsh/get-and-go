package nl.getandgo.application;

import com.github.javafaker.Faker;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.management.InstanceAlreadyExistsException;

@Configuration
public class DummyDataConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            for(City city:City.values()){
                for (Product.Category category: Product.Category.values()) {
                    AddProducts(city,2, category,userRepository);
                }
            }
        };
    }
    private void AddProducts(City city, int num_store, Product.Category category,UserRepository userRepository) throws InstanceAlreadyExistsException {
        Faker faker=new Faker();
        VendorUser vendor=new VendorUser(
                faker.internet().emailAddress(),
                faker.lorem().characters(8),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().avatar(),
                faker.phoneNumber().cellPhone());
        for (int i=0;i<num_store;i++){
            Store s1=new Store(
                    faker.company().name(),
                    faker.lorem().characters(50),
                    city,
                    faker.address().streetAddress(),
                    "https://picsum.photos/640/360",
                    faker.company().url()
            );
            Product p1 = new Product(
                    faker.commerce().productName(),
                    faker.number().numberBetween(1,99999),
                    faker.number().numberBetween(1,99999),
                    faker.number().numberBetween(20,1000),
                    Product.Status.ONSALE,
                    faker.company().buzzword(),
                    "https://picsum.photos/640/360",
                    category);
            s1.AddProduct(p1);
            vendor.addStore(s1);
            userRepository.save(vendor);
        }

    }
}
