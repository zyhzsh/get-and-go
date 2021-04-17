package nl.getandgo.application.service;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.City;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Product.Status;
import nl.getandgo.application.model.Product.Category;
import nl.getandgo.application.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    /**
     * Get List Of Products By Status:
     * - OnSale
     * - OffSale
     * - Archive
     * */
    public List<Product> getAllProducts(){return productRepository.findAll();}
    public List<Product> getProducts(Status status) {
        return productRepository.findProductsByStatus(status);
    }
    public List<Product> getProducts(String status) {
        Status s;
        try {
            s=Status.valueOf(status.toUpperCase());
            return productRepository.findProductsByStatus(s);
        }catch (Exception e){return null;}
    }

    /**
     * Get List Of Products By City and Product's Status
     * */
    public List<Product> getProductsByCityAndStatus(String city,Status status) {
        City c;
        try {
             c = City.valueOf(city.toUpperCase());
            return productRepository.findProductsByCityAndStatus(c,status);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Get List Of Products By Category and Product's Status
     * */
    public List<Product> getProductsByCategoryAndStatus(String category,Status status) {
        Category c;
        try{
            c = Category.valueOf(category.toUpperCase());
            return productRepository.findProductsByCategoryAndStatus(c,status);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * Get List Of Products By Category、Category and Product's Status
     * */
    public List<Product> getProductsByCategoryAndCityAndStatus(String category,String city,Status status) {
        Category ca;
        City ci;
        try{
            ca = Category.valueOf(category.toUpperCase());
            ci = City.valueOf(city.toUpperCase());
            return productRepository.findProductsByCategoryAndStatusAndCity(ca,ci,status);
        } catch (Exception e){return null;}
    }

    /**
     * Get Product By Product Id
     */
    public Optional<Product> getProductById(String id) {
       return productRepository.findById(Long.parseLong(id));
    }
}
