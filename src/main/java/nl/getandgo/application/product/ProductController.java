package nl.getandgo.application.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("api/products")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }
    @GetMapping(value = "api/products", params = "id")
    public Product getProductById(@RequestParam String id) {
        return productService.getProduct(id);
    }
    @GetMapping(value = "api/products", params = "city")
    public List<Product> getProductsByCity(@RequestParam String city) {
        return  productService.getProductsByCity(city);
    }
    @GetMapping(value = "api/products", params = "category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return  productService.getProductsByCategory(category);
    }
    @GetMapping(value="api/products",params ={"city","category"})
    public List<Product> getProductByCityAndCategory(@RequestParam String city,@RequestParam String category){
        return productService.getProductsByCategoryAndCity(category,city);
    }
    @PostMapping(value = "api/products")
    public boolean addNewProduct(@RequestBody Product product){
          return productService.addProduct(product);
    }
    @PutMapping(value = "api/products", params = "id")
    public Object updateProduct(@RequestBody Product product, String id) {
        Product temp = productService.upDateProduct(product, id);
        if (temp == null) {
            return ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(product, HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping(value = "api/products", params = "id")
    public Object deleteProduct(String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

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