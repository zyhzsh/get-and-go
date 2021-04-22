package nl.getandgo.application.repository;

import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Product.Category;
import nl.getandgo.application.model.Product.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findProductsByStatus(Status status);

    @Query("SELECT p FROM Product p WHERE p.category=?1 AND p.status=?2")
    List<Product> findProductsByCategoryAndStatus(Category category,Status status);

    @Query("SELECT p FROM Product p WHERE p.store.city=?1 AND p.status=?2")
    List<Product> findProductsByCityAndStatus(City city,Status status);

    @Query("SELECT p FROM Product p WHERE p.category=?1 And p.store.city=?2 AND p.status=?3")
    List<Product> findProductsByCategoryAndStatusAndCity(Category category,City city,Status status);

}
