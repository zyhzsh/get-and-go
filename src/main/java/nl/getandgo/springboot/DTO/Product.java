package nl.getandgo.springboot.DTO;

public class Product {
    private int id;
    private String name;
    private String vendor;
    private String picture;
    private double price;
    private int discount_rate_percentage;
    private String sub_description;
    private String endOfDay;
    private String location;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVendor() {
        return vendor;
    }

    public String getPicture() {
        return picture;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount_rate_percentage() {
        return discount_rate_percentage;
    }

    public String getSub_description() {
        return sub_description;
    }

    public String getEndOfDay() {
        return endOfDay;
    }

    public String getLocation() {
        return location;
    }


    public Product(int id,
                   String name,
                   String vendor,
                   String picture,
                   double price,
                   int discount_rate_percentage,
                   String sub_description,
                   String endOfDay,
                   String location) {
        this.id = id;
        this.name = name;
        this.vendor=vendor;
        this.picture = picture;
        this.price = price;
        this.discount_rate_percentage = discount_rate_percentage;
        this.sub_description = sub_description;
        this.endOfDay = endOfDay;
        this.location=location;
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
                ", sub_description="+ sub_description+
                ", endOfDay="+ endOfDay+
                ", location="+location+
                '}';
    }

}
