package nl.getandgo.application.service;

import lombok.NoArgsConstructor;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    //Constructor
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


//    public Product getProduct(String id) {
//       // productRepository.findAllByStatus(Product.Status.OnSale);
//    }
//    //GET
    public List<Product> getProducts() {
        return productRepository.findAllByStatus(Product.Status.OnSale);
    }

//    public List<Product> getProductsByCity(String city) {
//        List<Product> temp=new ArrayList<>();
//        for (Product p:productList) {
//            if(p.getStore().getCity().toString().toLowerCase().equals(city)){
//                temp.add(p);
//            }
//        }
//        return temp;
//    }
//    public List<Product> getProductsByCategory(String category) {
//        List<Product> temp=new ArrayList<>();
//        for (Product p:productList) {
//            if(p.getCategory().toString().toLowerCase().equals(category)){
//                temp.add(p);
//            }
//        }
//        return temp;
//    }
//    public List<Product> getProductsByCategoryAndCity(String category,String city) {
//        List<Product> temp=getProductsByCity(city);
//        temp.removeIf(p->(!(p.getCategory().toString().toLowerCase().equals(category))));
//        return temp;
//    }
//    //ADD
//    public boolean addProduct(Product product) {
//        //TODO Check
//
//        return true;
//
//    }
//    //UPDATE
//    public Product upDateProduct(Product product, String id) {
//        return null;
//    }
//    //DELETE
//    public void deleteProduct(String id) {
//
//    }
}
