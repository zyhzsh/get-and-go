package nl.getandgo.application;

import com.github.javafaker.Faker;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.repository.ProductRepository;

import nl.getandgo.application.repository.StoreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("*").allowedOrigins("http://localhost:8080");
//            }
//        };
//    }
    @Bean
    CommandLineRunner commandLineRunner( StoreRepository storeRepository) {

        return args -> {
            Store s1=new Store(
                    null,
                    "Food King",
                    "XXXXXXX",
                    City.Eindohoven,
                    "xxxsx",
                    "imfasdas",
                    "offfaisdniasdmas"
                    );

            Product p1 = new Product(
                    s1,
                    null,
                    "Takeout:Your LunchBox",
                    51,
                    102,
                    25,
                    Product.Status.OnSale,
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
                    "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                    Product.Category.Food,
                    null);

            try{s1.addprocut(p1);}
            catch (Exception e){
                System.out.println(e);
            }
            storeRepository.save(s1);


        };
    }
}
