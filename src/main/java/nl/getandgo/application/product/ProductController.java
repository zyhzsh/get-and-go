package nl.getandgo.application.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
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
    public ResponseEntity<Product> getProductById(@RequestParam String id) {
        Product product = productService.getProduct(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
    }

    @GetMapping(value = "api/products", params = "city")
    public ResponseEntity<List<Product>> getProductsByCity(@RequestParam String city) {
        List<Product> temp = productService.getProductsByCity(city);
        if (temp.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(temp);
    }
    @GetMapping(value = "api/products", params = "category")
    public ResponseEntity<List<Product>> getProductsByCategory(@RequestParam String category) {
        List<Product> temp = productService.getProductsByCategory(category);
        if (temp.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(temp);
    }
    @GetMapping(value="api/products",params ={"city","category"})
    public ResponseEntity<List<Product>> getProductByCityAndCategory(@RequestParam String city,@RequestParam String category){
        List<Product> temp = productService.getProductsByCategoryAndCity(category,city);
        if (temp.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(temp);
    }
    @PostMapping(value = "api/products")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product)
            throws URISyntaxException {
        Product new_product = productService.addProduct(product);
        if (new_product == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .queryParam("id", new_product.getProduct_id())
                    .buildAndExpand(new_product.getProduct_id())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(new_product);
        }
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