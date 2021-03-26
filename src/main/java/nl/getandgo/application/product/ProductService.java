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


    public ProductService(StoreService storeService){
        this.storeService = storeService;
        productList=new ArrayList<>();
        AddFakeProduct();
    }

    public void AddFakeProduct(){
        Faker faker =new Faker();
        Store store1=new Store(1L,1L,"Food King","ss", City.Eindohoven,"zzzz","xxxxxx","ssss");
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
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
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
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
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
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
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
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi ...",
                "https://images.unsplash.com/photo-1417325384643-aac51acc9e5d?q=75&fm=jpg&w=400&fit=max",
                Product.Category.Wellness,
                null));
        Store temp_store;
        Product temp_product;
        for (int i = 0; i < 3; i++) {
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Eindohoven,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Food,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Eindohoven,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Wellness,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Eindohoven,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Speciality,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Eindohoven,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Speciality,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Eindohoven,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Hotel,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Eindohoven,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.WorkShop,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Breda,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),faker.number().randomDigit(), Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Food,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Delft,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Food,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Tilburg,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Food,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Haarlem,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Food,null);
            productList.add(temp_product);
            temp_store=new Store(faker.number().randomNumber(), faker.number().randomNumber(),faker.company().name(), "bababa",City.Utrecht,faker.address().streetAddress(),"xxxxx","asdas");
            temp_product=new Product(faker.number().randomNumber(),temp_store,null,faker.commerce().productName(),faker.number().randomDigit(),faker.number().randomDigit(),56, Product.Status.OnSale, "","http://placeimg.com/640/360/any", Product.Category.Food,null);
            productList.add(temp_product);
        }
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


    public boolean addProduct(Product product) {
        //TODO Check

        return true;

    }
    public List<Product> getProducts() {
        return productList;
    }
    public Product upDateProduct(Product product, String id) {
        return null;
    }
    public void deleteProduct(String id) {

    }
}
