package nl.getandgo.application.config;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.dto.NewOrderDTO;
import nl.getandgo.application.model.*;
import nl.getandgo.application.repository.OrderRepository;
import nl.getandgo.application.repository.UserRepository;
import nl.getandgo.application.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.management.InstanceAlreadyExistsException;

@Configuration
@RequiredArgsConstructor
public class DummyDataConfig {
    private final BCryptPasswordEncoder passwordEncoder;
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, OrderService orderService) {
        return args -> {
            //Test Products
            for(City city:City.values()){
                for (Product.Category category: Product.Category.values()) {
                    AddProducts(city,2, category,userRepository);
                }
            }
            //Adding Test User Here
            VendorUser testvendor=new VendorUser(
                    "test@vendor.com",
                    passwordEncoder.encode("test"),
                    "sd",
                    "s",
                    "dd",
                    "ssd");
            ProductManagerUser testManager=new ProductManagerUser(
                    "test@manager.com",
                    passwordEncoder.encode("test"),
                    "manager",
                    "a",
                    "vdssfds",
                    "151518"
            );
            CustomerUser testCustomer_un_enabled=new CustomerUser(
                    "test@unenabledcustomer.com",
                    passwordEncoder.encode("test"),
                    "sds",
                    "asd");
            CustomerUser testCustomer=new CustomerUser(
                    "test@customer.com",
                    passwordEncoder.encode("test"),
                    "ShengHang",
                    "Zhu");
            testCustomer.setEnabled(true);
            userRepository.save(testvendor);
            userRepository.save(testCustomer);
            userRepository.save(testCustomer_un_enabled);
            userRepository.save(testManager);
        };

    }
    private void AddProducts(City city, int num_store, Product.Category category,UserRepository userRepository) throws InstanceAlreadyExistsException {
        Faker faker=new Faker();
        VendorUser vendor=new VendorUser(
                faker.internet().emailAddress(),
                passwordEncoder.encode("test"),
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
                    faker.lorem().characters(150),
                    "https://picsum.photos/640/360",
                    category);
            s1.AddProduct(p1);
            vendor.addStore(s1);
            userRepository.save(vendor);
        }

    }
}
