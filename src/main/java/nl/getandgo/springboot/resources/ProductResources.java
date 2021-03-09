package nl.getandgo.springboot.resources;
import nl.getandgo.springboot.DTO.Product;
import nl.getandgo.springboot.FakeDataStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ProductResources {

    private static final FakeDataStore Data=new FakeDataStore();

    @GetMapping("api/products")
    public List<Product> getAllProducts() {
      return Data.getProducts();
    }

    @GetMapping(value = "api/products",params = "id")
    public ResponseEntity<Product> getProductById(@RequestParam String id) {
        Product product=Data.getProduct(id);
        if(product!=null){
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "api/products",params = "location")
    public ResponseEntity<List<Product>> getProductsByLocation(@RequestParam String location) {
        List<Product> temp=Data.getProductsByLocation(location);
        if(temp.stream().count()==0){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(Data.getProductsByLocation(location));
    }

    @GetMapping(value = "api/products",params = "category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam String category) {
        List<Product> temp=Data.getProductsByCategory(category);
        if(temp.stream().count()==0){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(Data.getProductsByCategory(category));
    }

    @PostMapping(value = "api/products")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product)
            throws URISyntaxException {
        Product newproduct = Data.addProduct(product);
        if(newproduct==null){
            return ResponseEntity.notFound().build();
        }else{
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .queryParam("id",newproduct.getId())
                    .buildAndExpand(newproduct.getId())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(newproduct);
        }
    }

    @PutMapping(value = "api/products",params = "id")
    public Object updateProduct(@RequestBody Product product,String id){
       Product temp= Data.upDateProduct(product,id);
        if(temp==null){
            return ResponseEntity.notFound().build();
        }else{
            return new ResponseEntity<>(product,HttpStatus.NO_CONTENT);
        }
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
