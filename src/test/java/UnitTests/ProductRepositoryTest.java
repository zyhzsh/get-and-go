package UnitTests;

import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.repository.ProductRepository;
import nl.getandgo.application.repository.StoreRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ProductRepositoryTest {

    // @Autowired
    // private ProductRepository productRepository;
    // @Autowired
    // private StoreRepository storeRepository;

    @Test
    void findAllByStatus() {
        // Arrange
        // Store s1=new Store(null, "Food King", "XXXXXXX", City.Eindohoven, "xxxsx", "imfasdas", "offfaisdniasdmas");
        // Product p1 = new Product(s1, null, "Takeout:Your LunchBox", 51, 102, 25, Product.Status.OnSale, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...", "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max", Product.Category.Food, null);
        // s1.addprocut(p1);
        // storeRepository.save(s1);
        // Act
        // then

    }
}