package nl.getandgo.springboot.Controller;

import nl.getandgo.springboot.DTO.Product;
import nl.getandgo.springboot.FakeDataStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private static final FakeDataStore Data=new FakeDataStore();

    //Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return Data.getProducts();
    }


    //Get Specific Product by Id
    @GetMapping(value = "/products",params = "id")
    public Object getProductById(@RequestParam String id) {
        Product product=Data.getProduct(Integer.parseInt(id));
        if(product==null){
            return new ResponseEntity<>("404 ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
    }

    //Get List of Products by Location
    @GetMapping(value = "/products",params = "location")
    public List<Product> getProductByLocation(@RequestParam String location) {
        return Data.getProducts(location);
    }


    //multiple param test...
    @GetMapping(value = "/products",params ={"location","price"} )
    public String getProductByLocationAndPrice(@RequestParam String location,
                                               @RequestParam String price) {
        return "location: "+location+" price : "+price;
    }

}
