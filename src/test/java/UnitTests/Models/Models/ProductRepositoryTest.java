//package UnitTests.Models.Models;
//import com.github.javafaker.Faker;
//import nl.getandgo.application.model.Product;
//import org.junit.jupiter.api.Test;
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//
//
//class ProductTests {
//    @Test
//    void ProductConstructorTest() {
//        // Arrange
//        Faker faker= new Faker();
//        Product p1 = new Product(
//                faker.commerce().productName(),
//                51,
//                102,
//                25,
//                Product.Status.ONSALE,
//                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
//                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
//                Product.Category.FOOD);
//        Long product_id= p1.getProduct_id();
//        // Act
//        boolean saved=productRepository.findById(product_id).isPresent();
//        // Assert
//        assertThat(saved).isTrue();
//    }
//
//}