package nl.getandgo.application;
import com.github.javafaker.Faker;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.repository.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DummyDataConfig {
    @Bean
    CommandLineRunner commandLineRunner(StoreRepository storeRepository) {

        return args -> {
            AddProducts(City.EINDOHOVEN,5, Product.Category.FOOD,storeRepository);
            AddProducts(City.EINDOHOVEN,10, Product.Category.WELLNESS,storeRepository);
            AddProducts(City.EINDOHOVEN,15, Product.Category.SPECIALITY,storeRepository);
            AddProducts(City.BREDA,15, Product.Category.EVENT,storeRepository);
            AddProducts(City.HAARLEM,15, Product.Category.EVENT,storeRepository);
            AddProducts(City.DELFT,15, Product.Category.EVENT,storeRepository);
            AddProducts(City.UTRECHT,15, Product.Category.EVENT,storeRepository);
        };
    }
    private void AddProducts(City city, int num, Product.Category category,StoreRepository storeRepository){
        Faker faker=new Faker();
        for (int i=0;i<num;i++){
            Store s1=new Store(
                    null,
                    "Food King",
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
            storeRepository.save(s1);
        }

    }
}
