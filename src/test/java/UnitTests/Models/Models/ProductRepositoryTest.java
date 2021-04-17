package UnitTests.Models.Models;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Store;
import nl.getandgo.application.service.ProductService;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.Mock;


class ProductRepositoryTest {

    @Mock
    private ProductService productService;

    @Test
    void findAllByStatus() {
        // Arrange

        Store s1=new Store(null, "Food King", "XXXXXXX", City.EINDOHOVEN, "xxxsx", "imfasdas", "offfaisdniasdmas");
        Product p1 = new Product( null, "Takeout:Your LunchBox", 51, 102, 25, Product.Status.ONSALE, "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...", "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max", Product.Category.FOOD, null);
        // Act
        s1.AddProduct(p1);
        // Assert
        assertEquals(s1.getProducts().get(0),p1);
    }
}