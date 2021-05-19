package UnitTests.Serivices;

import com.github.javafaker.Faker;
import nl.getandgo.application.dto.LoginRequestDTO;
import nl.getandgo.application.dto.LoginResponseDTO;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.filter.JwtHelper;
import nl.getandgo.application.model.ConfirmationToken;
import nl.getandgo.application.model.CustomerUser;
import nl.getandgo.application.model.VendorUser;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import nl.getandgo.application.service.ConfirmationTokenService;
import nl.getandgo.application.service.EmailService;
import nl.getandgo.application.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.management.InstanceAlreadyExistsException;
import java.time.LocalDateTime;
import java.util.Optional;


public class UserServiceTest {
    private Faker faker;

    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private  StoreRepository storeRepository;
    @Mock
    private  JwtHelper jwtHelper;
    @Mock
    private  ConfirmationTokenService confirmationTokenService;
    @Mock
    private  EmailService emailService;

    @Before
    public void Setup(){
        faker=new Faker();
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = InstanceAlreadyExistsException.class)
    public void Register_New_Customer_When_Email_Address_Already_Exist_And_Activated_Test() throws InstanceAlreadyExistsException {
        //Arrange New Register User
        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        NewCustomerDTO new_customer = new NewCustomerDTO(email,password,first_name,last_name);
        CustomerUser user= new CustomerUser(email,password,first_name,last_name);
        user.setEnabled(true);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));
        userService.registerCustomerUser(new_customer);
    }

    @Test
    public void Register_New_Customer_When_Email_Address_Already_Exist_But_NotActivated_Test() throws InstanceAlreadyExistsException {
        //Arrange New Register User
        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        NewCustomerDTO new_customer = new NewCustomerDTO(email,password,first_name,last_name);
        CustomerUser user= new CustomerUser(email,password,first_name,last_name);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));
        userService.registerCustomerUser(new_customer);
    }

    @Test(expected = InstanceAlreadyExistsException.class)
    public void Register_Vendor_User_When_Email_Address_Already_Exist_Test() throws InstanceAlreadyExistsException {
        //Arrange New Register User
        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        String avatar_link=faker.internet().avatar();
        String phone=faker.phoneNumber().phoneNumber();
        NewVendorDTO newVendor = new NewVendorDTO(email,password,first_name,last_name,avatar_link,phone);
        VendorUser existVendor=new VendorUser(email,password,first_name,last_name,avatar_link,phone);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(existVendor));
        userService.registerVendorUser(newVendor);
    }

    @Test
    public void Active_User_By_Token_Test(){
        //Arrange
        String token=faker.crypto().toString();
        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        CustomerUser user= new CustomerUser(email,password,first_name,last_name);
        ConfirmationToken confirmationToken=new ConfirmationToken(token, LocalDateTime.now(),LocalDateTime.now().plusMinutes(15),user);
        //Act
        Mockito.when(confirmationTokenService.findToken(token)).thenReturn(confirmationToken);
        boolean result = userService.activateUserByToken(token);
        //Assert
        Assert.assertEquals(result,true);

    }

    @Test
    public void Active_User_By_Expired_Token_Test(){
        //Arrange
        String token=faker.crypto().toString();
        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        CustomerUser user= new CustomerUser(email,password,first_name,last_name);
        ConfirmationToken confirmationToken=new ConfirmationToken(token, LocalDateTime.now().plusMinutes(-20),LocalDateTime.now().plusMinutes(-10),user);
        //Act
        Mockito.when(confirmationTokenService.findToken(token)).thenReturn(confirmationToken);
        boolean result = userService.activateUserByToken(token);
        //Assert
        Assert.assertEquals(result,false);

    }

    @Test
    public void Active_User_By_Non_Exist_Token_Test(){
        //Arrange
        String token=faker.crypto().toString();
        //Act
        Mockito.when(confirmationTokenService.findToken(token)).thenReturn(null);
        boolean result = userService.activateUserByToken(token);
        //Assert
        Assert.assertEquals(result,false);

    }


    @Test
    public void Login_With_Wrong_Password_Test(){
        //Arrange
        String email=faker.internet().emailAddress();
        String wrong_password=faker.lorem().fixedString(8);
        LoginRequestDTO login_request=new LoginRequestDTO(email,wrong_password);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        String password=faker.lorem().fixedString(8);
        CustomerUser user= new CustomerUser(email,password,first_name,last_name);
        user.setEnabled(true);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));
        LoginResponseDTO response=userService.Login(login_request);
        //Assert
        String expected_msg="E-mail does not exists or the password is wrong";
        Assert.assertEquals(response.getResult(),expected_msg);
    }

    @Test
    public void Login_With_UnActivated_Account_Test(){
        //Arrange
        String email=faker.internet().emailAddress();
        String wrong_password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        String password=faker.lorem().fixedString(8);
        LoginRequestDTO login_request=new LoginRequestDTO(email,password);
        CustomerUser user= new CustomerUser(email,password,first_name,last_name);
        user.setEnabled(false);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));
        LoginResponseDTO response=userService.Login(login_request);
        //Assert
        String expected_msg="User Need to be Activated ~! ";
        Assert.assertEquals(response.getResult(),expected_msg);
    }

    @Test
    public void Login_With_Enabled_Account_Test(){
        //Arrange
        String email=faker.internet().emailAddress();
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        String password=faker.lorem().fixedString(8);
        CustomerUser user= new CustomerUser(email,password,first_name,last_name);
        LoginRequestDTO login_request=new LoginRequestDTO(email,password);
        user.setEnabled(true);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));
        LoginResponseDTO response=userService.Login(login_request);
        //Assert
        String expected_msg="login successful";
        Assert.assertEquals(expected_msg,response.getResult());
    }


}
