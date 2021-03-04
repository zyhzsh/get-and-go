package nl.getandgo.springboot.DTO;


import lombok.Getter;
import lombok.Setter;

public class Product {

    @Getter private final String id;
    @Getter @Setter private String name;
    @Getter @Setter private String vendor;
    @Getter @Setter private String picture;
    @Getter @Setter private Category category;
    @Getter @Setter private double price;
    @Getter @Setter private int discount_rate_percentage;
    @Getter @Setter private String description;
    @Getter @Setter private String endOfDay;
    @Getter @Setter private String location;
    @Getter @Setter private int sold;
    @Getter @Setter private String vendor_id;
    @Getter @Setter private String voucher_id;
    @Getter @Setter private String review_id;


    public enum Category{
        Wellness,Event,Food,WorkShop,Speciality
    }

    public Product(String id,
                   String name,
                   String vendor,
                   Category category,
                   String picture,
                   double price,
                   int discount_rate_percentage,
                   String description,
                   String endOfDay,
                   String location,
                   String vendor_id,
                   String voucher_id,
                   String review_id) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
        this.category=category;
        this.picture = picture;
        this.price = price;
        this.discount_rate_percentage = discount_rate_percentage;
        this.description = description;
        this.endOfDay = endOfDay;
        this.location = location;
        this.sold = 0;
        this.vendor_id = vendor_id;
        this.voucher_id = voucher_id;
        this.review_id = review_id;
    }




    @Override
    public String toString() {
        return "product{" +
                "product_id=" + id +
                ", name=" + name +
                ", vendor="+vendor+
                ", picture=" +picture  +
                ", price="+ price+
                ", discount_rate_percentage="+ discount_rate_percentage+
                ", sub_description="+ description+
                ", endOfDay="+ endOfDay+
                ", location="+location+
                '}';
    }

}
