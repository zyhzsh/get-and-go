package nl.getandgo.springboot.resources;
import nl.getandgo.springboot.DTO.Product;
import nl.getandgo.springboot.FakeDataStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResources {

    private static final FakeDataStore Data=new FakeDataStore();


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

    @GetMapping(value = "api/products",params = "location")
    public List<Product> getProductsByLocation(@RequestParam String location) {
        return Data.getProductsByLocation(location);
    }

    @GetMapping(value = "api/products",params = "category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return Data.getProductsByCategory(category);
    }




    @PostMapping("api/products")
    public Object addNewProduct(@RequestBody Product product) {
        boolean result=Data.addProduct(product);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "api/products")
    public Object updateProduct(@RequestBody Product product){
        Data.upDateProduct(product);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "api/products",params = "id")
    public Object deleteProduct(String id) {
        Data.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }






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
