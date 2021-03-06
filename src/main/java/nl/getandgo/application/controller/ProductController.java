package nl.getandgo.application.controller;

import lombok.RequiredArgsConstructor;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    /**
     * Get List Of Products By Status = OnSale
     * */
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
    @PreAuthorize("hasAuthority('GET_ALL_STATUS_PRODUCTS')")
    @GetMapping(value = "api/products",params = {"status"})
    public List<Product> getAllProductsWithStatus(@RequestParam String status){
       return productService.getProducts(status);
    }
    

}