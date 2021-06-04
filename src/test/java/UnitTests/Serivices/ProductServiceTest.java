package UnitTests.Serivices;

import com.github.javafaker.Faker;
import nl.getandgo.application.dto.NewVoucherDTO;
import nl.getandgo.application.model.Product;
import nl.getandgo.application.model.Voucher;
import nl.getandgo.application.repository.ProductRepository;
import nl.getandgo.application.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

public class ProductServiceTest {
    private Faker faker;
    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void Setup(){
        faker=new Faker();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void AddVoucherTest(){
        //Arrange
        Product product =new Product("hah",11,22,1.5, Product.Status.ONSALE,"sss","ss", Product.Category.FOOD);
        NewVoucherDTO newVoucher=new NewVoucherDTO(product.getProduct_id(),51.1,"sdas","asdas");
        Voucher voucher= new Voucher(51.1,"sdas","asdas");
        product.addVoucher(voucher);
        //Act
        productService.addVoucherForProduct(newVoucher);
        Mockito.when(productRepository.findById(product.getProduct_id())).thenReturn(Optional.of(product));

        //Assert
        String title =product.getVouchers().get(1).getTitle();
        assertEquals(title,newVoucher.getTitle());
    }
}
