package UnitTests.Models;

import com.github.javafaker.Faker;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Review;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ReviewTest {

    private static Faker faker;
    @BeforeAll
    public static void Setup(){
        faker=new Faker();
    }

    @Test
    public void NewReviewTest(){
        //Arrange
        Product product=mock(Product.class);
        CustomerUser reviewer=mock(CustomerUser.class);
        LocalDateTime createdAt=LocalDateTime.now();
        String content= faker.lorem().characters(50);
        double rating=6.1;

        //Act
        Review review = new Review(
                product,
                reviewer,
                createdAt,
                content,
                rating);
        //Assert
        assertEquals(true,review.getComments().isEmpty());
        assertEquals(product,review.getProduct());
        assertEquals(reviewer,review.getReviewer());
        assertEquals(createdAt,review.getCreatedAt());
        assertEquals(content,review.getContent());
        assertEquals(rating,review.getRating());

    }

}
