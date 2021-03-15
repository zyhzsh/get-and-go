package nl.getandgo.demo;

import nl.getandgo.demo.DTO.Product;
import nl.getandgo.demo.DTO.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {
    private final static List<Product> productList=new ArrayList<>();
    private final static List<User> userList=new ArrayList<>();
    public FakeDataStore(){
        productList.add(new Product("1000001",
                "Takeout:Your LunchBox",
                "FoodKing",
                Product.Category.Food,
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
                Product.Category.Wellness,
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
                Product.Category.Speciality,
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
                Product.Category.Wellness,
                "a link of a picture ?",
                30,
                10,
                "bla bla bla",
                "2021-4-2",
                "Amersfoort",
                "",
                "",
                ""));
        userList.add(new User("admin","Admin@outlook.com","admin",User.AccountType.admin));
        userList.add(new User("vendor","Admin@outlook.com","vendor",User.AccountType.vendor));
        userList.add(new User("normal","Admin@outlook.com","normal",User.AccountType.normal));
    }

    public List<Product> getProducts(){ return productList; }

    //get filtered product by location
    public List<Product> getProductsByLocation(String location){
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
    public Product addProduct(Product product){
        if(getProduct(product.getId())!=null) { return null; }
        productList.add(new Product(product.getId(),
                product.getName(),
                product.getVendor(),
                product.getCategory(),
                product.getPicture(),
                product.getPrice(),
                product.getDiscount_rate_percentage(),
                product.getDescription(),
                product.getEndOfDay(),
                product.getLocation(),
                product.getVendor_id(),
                product.getVoucher_id(),
                product.getReview_id()));
        return product;
    }

    public Product upDateProduct(Product product,String id){
        Product pointer=getProduct(id);
        if(pointer!=null) {
            pointer.setName(product.getName());
            pointer.setDescription(product.getDescription());
            pointer.setEndOfDay(product.getEndOfDay());
            pointer.setPicture(product.getPicture());
            pointer.setPrice(product.getPrice());
            //....
            return pointer;
        }
        else {
            return null;
        }
    }

    public boolean deleteProduct(String id){
        Product temp=getProduct(id);
        if(temp==null){return false;}
        else {
            productList.remove(temp);
            return true;
        }
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> filtered=new ArrayList<>();
        for (Product p:productList) {
            if(p.getCategory().toString().equals(category)){
                filtered.add(p);
            }
        }
        return filtered;
    }

    public User Login(User user){
        for (User u:userList) {
          if(u.getUsername().equals(user.getUsername())&&u.getPassword().equals(user.getPassword()))
          {
              return u;
          }
        }
        return null;
    }
}
