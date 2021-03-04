package nl.getandgo.springboot.DTO;

public class Product {

    private final String id;
    private final String name;
    private final String vendor;
    private final String picture;
    private final double price;
    private final int discount_rate_percentage;
    private final String description;
    private final String endOfDay;
    private final String location;
    private final int sold;
    private final String vendor_id;
    private final String voucher_id;
    private final String review_id;


    public Product(String id,
                   String name,
                   String vendor,
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
    public String getId() {
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

    public String getDescription() {
        return description;
    }

    public String getEndOfDay() {
        return endOfDay;
    }

    public String getLocation() {
        return location;
    }

    public int getSold() {
        return sold;
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public String getReview_id() {
        return review_id;
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
