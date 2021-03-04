package nl.getandgo.springboot;

import nl.getandgo.springboot.DTO.Product;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {
    private final static List<Product> productList=new ArrayList<>();

    public FakeDataStore(){
        productList.add(new Product("1000001",
                "Takeout:Your LunchBox",
                "FoodKing",
                "a link of a picture ?",
                50,
                25,
                "bla bla bla",
                "2021-3-25",
                "Eindhoven",
                "",
                "",
                ""));
        productList.add(new Product("1000002",
                "Foot massage",
                "Tom's Healing Therapy",
                "a link of a picture ?",
                67,
                41,
                "bla bla bla",
                "2021-3-26",
                "Eindhoven",
                "",
                "",
                "" ));
        productList.add(new Product("1000003",
                "Air conditioning service",
                "Auto Center Karsmaker",
                "a link of a picture ?",
                80,
                51,
                "bla bla bla",
                "2021-3-26",
                "Tilburg",
                "",
                "",
                ""));
        productList.add(new Product("1000004",
                "Hairdressing treatment",
                "Exphairsr",
                "a link of a picture ?",
                30,
                10,
                "bla bla bla",
                "2021-4-2",
                "Amersfoort",
                "",
                "",
                ""));
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
    public Product getProduct(String id){
        for (Product p : productList) {
            if (p.getId().equals(id))
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
