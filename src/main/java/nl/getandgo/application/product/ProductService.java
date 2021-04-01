package nl.getandgo.application.product;
import com.github.javafaker.Faker;

import nl.getandgo.application.location.City;
import nl.getandgo.application.store.Store;

import nl.getandgo.application.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public static List<Product> productList;

    @Autowired
    private final StoreService storeService;
    //Constructor
    public ProductService(StoreService storeService){
        this.storeService = storeService;
        productList=new ArrayList<>();
        AddFakeProduct();
    }
    //Fake Data
    public void AddFakeProduct(){
        Faker faker =new Faker();
        productList.add(new Product(
                storeService.getStoreList().get(0),
                null,
                "Takeout:Your LunchBox",
                51,
                102,
                25,
                Product.Status.OnSale,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Food,
                null));
        productList.add(new Product(
                storeService.getStoreList().get(1),
                null,
                "Foot massage",
                9999,
                50,
                45,
                Product.Status.OnSale,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Wellness,
                null));
        productList.add(new Product(
                storeService.getStoreList().get(2),
                null,
                "Air conditioning service",
                9999,
                123,
                67,
                Product.Status.OnSale,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Speciality,
                null));
        productList.add(new Product(
                storeService.getStoreList().get(3),
                null,
                "Hairdressing treatment",
                9999,
                53,
                34,
                Product.Status.OnSale,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Wellness,
                null));
    }

    public Product getProduct(String id) {
        for (Product p:productList) {
            if(p.getProduct_id().toString().equals(id)){
                return p;
            }
        }
        return null;
    }
    //GET
    public List<Product> getProducts() {
        return productList;
    }
    public List<Product> getProductsByCity(String city) {
        List<Product> temp=new ArrayList<>();
        for (Product p:productList) {
            if(p.getStore().getCity().toString().toLowerCase().equals(city)){
                temp.add(p);
            }
        }
        return temp;
    }
    public List<Product> getProductsByCategory(String category) {
        List<Product> temp=new ArrayList<>();
        for (Product p:productList) {
            if(p.getCategory().toString().toLowerCase().equals(category)){
                temp.add(p);
            }
        }
        return temp;
    }
    public List<Product> getProductsByCategoryAndCity(String category,String city) {
        List<Product> temp=getProductsByCity(city);
        temp.removeIf(p->(!(p.getCategory().toString().toLowerCase().equals(category))));
        return temp;
    }
    //ADD
    public boolean addProduct(Product product) {
        //TODO Check

        return true;

    }
    //UPDATE
    public Product upDateProduct(Product product, String id) {
        return null;
    }
    //DELETE
    public void deleteProduct(String id) {

    }
}
