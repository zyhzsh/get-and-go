package nl.getandgo.springboot.resources;

import nl.getandgo.springboot.DTO.Product;
import nl.getandgo.springboot.FakeDataStore;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResources {

    private static final FakeDataStore Data=new FakeDataStore();

//    //Get All Products
//    @GetMapping("api/products")
//    public List<Product> getAllProducts() {
//        return Data.getProducts();
//    }
      //Get All Products
    @GetMapping("api/products")
    public Object getAllProducts() {
        List <Product> products = Data.getProducts();
        if(products==null){
            return new ResponseEntity<>("no data", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products,HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "api/products",params = "id")
    public Product getProductById(@RequestParam String id) {
        Product product=Data.getProduct(id);
        if(product!=null){
            return product;
        }
        return null;
    }

    //Get List of Products by Location
    @GetMapping(value = "api/products",params = "location")
    public List<Product> getProductByLocation(@RequestParam String location) {
        return Data.getProducts(location);
    }

    @PostMapping("api/products")
    public void addingProducts(@RequestBody Product product) {
        Data.addProduct(product);
    }
    @PutMapping("")




    /*
    * Some Example for my self to check
    * 1.multiple param test...
    * 2.Return request with http Status code : 404
    *
    *****************************************************
    //1.multiple param test...
    @GetMapping(value = "api/products",params ={"location","price"} )
    public String example_getProductByLocationAndPrice(@RequestParam String location,
                                               @RequestParam String price) {
        return "location: "+location+" price : "+price;
    }

    //2.Return request with http Status code : 404
    @GetMapping(value = "api/products",params = "id")
    public Object example_getProductById(@RequestParam String id) {
        Product product=Data.getProduct(id);
        if(product==null){
            return new ResponseEntity<>("404 ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
    }
    */
}
