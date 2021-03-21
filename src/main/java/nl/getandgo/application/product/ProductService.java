package nl.getandgo.application.product;
import nl.getandgo.application.location.City;
import nl.getandgo.application.store.Store;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public static List<Product> productList;

    public ProductService(){
        productList=new ArrayList<>();
        AddFakeProduct();
    }
    public void AddFakeProduct(){
        Store store1=new Store(1L,1L,"Food King","blablabla", City.Eindohoven,"zzzz","xxxxxx","ssss");
        Store store2=new Store(2L,2L,"Store 2","blablabla", City.Tilburg,"zzzz","xxxxxx","ssss");
        Store store3=new Store(3L,3L,"Store 3","blablabla", City.Delft,"zzzz","xxxxxx","ssss");
        Store store4=new Store(4L,4L,"Store 4","blablabla", City.Breda,"zzzz","xxxxxx","ssss");
        productList.add(new Product(1L,
                store1,
                null,
                "Takeout:Your LunchBox",
                51,
                102,
                25,
                Product.Status.OnSale,
                "blablablablablablbla~~~!",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Food,
                null));
        productList.add(new Product(2L,
                store2,
                null,
                "Foot massage",
                9999,
                50,
                45,
                Product.Status.OnSale,
                "blablablablablablbla~~~!",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Wellness,
                null));
        productList.add(new Product(3L,
                store3,
                null,
                "Air conditioning service",
                9999,
                123,
                67,
                Product.Status.OnSale,
                "blablablablablablbla~~~!",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Speciality,
                null));
        productList.add(new Product(4L,
                store4,
                null,
                "Hairdressing treatment",
                9999,
                53,
                34,
                Product.Status.OnSale,
                "blablablablablablbla~~~!",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Wellness,
                null));
    }

    public List<Product> getProducts() {
        return productList;
    }

    public Product getProduct(String id) {
        for (Product p:productList) {
            if(p.getProduct_id().toString().equals(id)){
                return p;
            }
        }
        return null;
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

    public Product addProduct(Product product) {
        return null;
    }

    public Product upDateProduct(Product product, String id) {
        return null;
    }

    public void deleteProduct(String id) {

    }
}
