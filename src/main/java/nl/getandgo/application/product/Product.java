package nl.getandgo.application.product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import nl.getandgo.application.review.Review;
import nl.getandgo.application.store.Store;
import nl.getandgo.application.voucher.Voucher;

import java.util.List;

@AllArgsConstructor
@ToString
public class Product {
    @Getter @Setter private Long product_id;
    @Getter @Setter private Store store;
    @Getter @Setter private List<Review> review;
    @Getter @Setter private String product_name;
    @Getter @Setter private int current_stock;
    @Getter @Setter private int sold;
    @Getter @Setter private double price;
    @Getter @Setter private Status status;
    @Getter @Setter private String description;
    @Getter @Setter private String img;
    @Getter @Setter private Category category;
    @Getter @Setter private List<Voucher> vouchers;
    public enum Status{
        OnSale,OffShelf,Archive
    }
    public enum Category{
        Wellness,Hotel,Event,Food,WorkShop,Speciality
    }
}
