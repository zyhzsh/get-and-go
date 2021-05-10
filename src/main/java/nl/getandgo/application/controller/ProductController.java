package nl.getandgo.application.controller;
import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.*;
import nl.getandgo.application.service.ProductService;
import nl.getandgo.application.service.StoreService;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    /**
     * Get List Of Products By Status = OnSale
     * */

    @PreAuthorize("hasAuthority('BROWSER_ON_SALE_PRODUCT')")
    @GetMapping("api/products")
    public List<Product> getAllOnSaleProducts() {
        return productService.getProducts(Product.Status.ONSALE);
    }
    /**
     * Get Product By Product Id
     * */
    @GetMapping(value = "api/products", params = "id")
    public Object getProductById(@RequestParam String id) {
       return productService.getProductById(id);
    }
    /**
     * Get All OnSale Products By It's City
     * */
    @GetMapping(value = "api/products", params = "city")
    public List<Product> getOnSaleProductsByCity(@RequestParam String city) {
        return  productService.getProductsByCityAndStatus(city, Product.Status.ONSALE);
    }
    /**
     * Get All OnSale Products By It's Category
     * */
    @GetMapping(value = "api/products", params = "category")
    public List<Product> getOnSaleProductsByCategory(@RequestParam String category) {
        return  productService.getProductsByCategoryAndStatus(category, Product.Status.ONSALE);
    }
    /**
     * Get All OnSale Products By It's City And Category
     * */
    @GetMapping(value="api/products",params ={"city","category"})
    public List<Product> getOnSaleProductByCityAndCategory(@RequestParam String city,@RequestParam String category){
        return productService.getProductsByCategoryAndCityAndStatus(category,city, Product.Status.ONSALE);
    }

    /**
     * Get All Products By
     * */
    @GetMapping(value = "api/products",params = {"status"})
    public List<Product> getAllProductsWithStatus(@RequestParam String status){
       return productService.getProducts(status);
    }

//    @PostMapping(value = "api/products")
//    public boolean addNewProduct(@RequestBody Product product){
//          return productService.addProduct(product);
//    }

//    @PutMapping(value = "api/products", params = "id")
//    public Object updateProduct(@RequestBody Product product, String id) {
//        Product temp = productService.upDateProduct(product, id);
//        if (temp == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return new ResponseEntity<>(product, HttpStatus.NO_CONTENT);
//        }
//    }
//    @DeleteMapping(value = "api/products", params = "id")
//    public Object deleteProduct(String id) {
//        productService.deleteProduct(id);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }

}