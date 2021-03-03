package nl.getandgo.springboot;

import nl.getandgo.springboot.DTO.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {
    private final List<Product> productList=new ArrayList<>();

    public FakeDataStore(){
        productList.add(new Product(1,
                "Takeout:Your LunchBox",
                "FoodKing",
                "a link of a picture ?",
                50,
                50,
                "bla bla",
                "2021-3-25",
                "Eindhoven"));
        productList.add(new Product(2,
                "Foot massage",
                "Tom's Healing Therapy",
                "a link of a picture ?",
                80,
                50,
                "bla bla",
                "2021-3-27",
                "Eindhoven"));
        productList.add(new Product(3,
                "Air conditioning service",
                "Auto Center Karsmaker",
                "a link of a picture ?",
                80,
                25,
                "",
                "2021-3-25",
                "Eindhoven"));
        productList.add(new Product(4,
                "Hairdressing treatment",
                "Exphairs",
                "a link of a picture ?",
                35,
                50,
                "",
                "2021-5-25",
                "Amersfoort"));
    }

    public List<Product> getProducts(){ return productList; }

    //get filtered product by location
    public List<Product> getProducts(String location){
        List<Product> filetered = new ArrayList<>();
        for (Product p : productList) {
            if (p.getLocation().equals(location)) {
                filetered.add(p);
            }
        }
        return filetered;
    }

    //get specific product by id
    public Product getProduct(int id){
        for (Product p : productList) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    //add product to list
    public boolean addProduct(Product product){
        if(getProduct(product.getId())!=null) { return  false; }
        productList.add(product);
        return true;
    }


}
