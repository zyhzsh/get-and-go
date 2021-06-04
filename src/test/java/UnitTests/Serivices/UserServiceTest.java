package UnitTests.Serivices;

import UnitTests.Models.VendorUserTest;
import com.github.javafaker.Faker;
import nl.getandgo.application.dto.LoginRequestDTO;
import nl.getandgo.application.dto.LoginResponseDTO;
import nl.getandgo.application.dto.NewCustomerDTO;
import nl.getandgo.application.dto.NewVendorDTO;
import nl.getandgo.application.filter.JwtHelper;
import nl.getandgo.application.model.*;
import nl.getandgo.application.repository.StoreRepository;
import nl.getandgo.application.repository.UserRepository;
import nl.getandgo.application.service.ConfirmationTokenService;
import nl.getandgo.application.service.EmailService;
import nl.getandgo.application.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.management.InstanceAlreadyExistsException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    public void Setup(){
        faker=new Faker();
        MockitoAnnotations.initMocks(this);
    }

    @Test
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
        Assertions.assertThrows(InstanceAlreadyExistsException.class,()->{
            userService.registerCustomerUser(new_customer);
        });
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

    @Test
    public void Register_New_Customer_Test() throws InstanceAlreadyExistsException {
        //Arrange
        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        NewCustomerDTO new_customer = new NewCustomerDTO(email,password,first_name,last_name);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.empty());
        userService.registerCustomerUser(new_customer);
    }

    @Test
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
        Assertions.assertThrows(InstanceAlreadyExistsException.class,()->{
            userService.registerVendorUser(newVendor);
        });
    }

    @Test
    public void Register_Vendor_User_Test() throws InstanceAlreadyExistsException {
        //Arrange
        String email=faker.internet().emailAddress();
        String password=faker.lorem().fixedString(8);
        String first_name=faker.name().firstName();
        String last_name=faker.name().lastName();
        String avatar_link=faker.internet().avatar();
        String phone=faker.phoneNumber().phoneNumber();
        NewVendorDTO newVendor = new NewVendorDTO(email,password,first_name,last_name,avatar_link,phone);
        //Act
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.empty());
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
        assertEquals(result,true);

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
        assertEquals(result,false);

    }

    @Test
    public void Active_User_By_Non_Exist_Token_Test(){
        //Arrange
        String token=faker.crypto().toString();
        //Act
        Mockito.when(confirmationTokenService.findToken(token)).thenReturn(null);
        boolean result = userService.activateUserByToken(token);
        //Assert
        assertEquals(result,false);

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
        //Assert.assertEquals(response.getResult(),expected_msg);
        assertEquals(response.getResult(),expected_msg);
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
        assertEquals(response.getResult(),expected_msg);
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
        Mockito.when(passwordEncoder.matches(login_request.getPassword(),user.getPassword())).thenReturn(true);
        Mockito.when(userRepository.findUserByEmail(email)).thenReturn(Optional.of(user));
        LoginResponseDTO response=userService.Login(login_request);
        //Assert
        String expected_msg="login successful";
        assertEquals(expected_msg,response.getResult());
    }

    @Test
    public void Get_Vendors_Test(){
        //Arrange
        List<User> vendors = List.of(
                new VendorUser(faker.internet().emailAddress(),faker.lorem().characters(10),faker.name().firstName(),faker.name().lastName(),"",""),
                new VendorUser(faker.internet().emailAddress(),faker.lorem().characters(10),faker.name().firstName(),faker.name().lastName(),"",""),
                new VendorUser(faker.internet().emailAddress(),faker.lorem().characters(10),faker.name().firstName(),faker.name().lastName(),"","")
        );
        //Action
        Mockito.when(userRepository.findAllByUserType(UserType.VENDORUSER)).thenReturn(vendors);

        //Assert
        assertEquals(userService.getAllVendor(),vendors);
    }

    @Test
    public void Load_User_By_Username_Test(){
        //Arrange
        String email_1=faker.internet().emailAddress();
        String email_2=faker.internet().emailAddress();
        String password_1=faker.lorem().fixedString(8);
        String password_2=faker.lorem().fixedString(8);
        String first_name_1=faker.name().firstName();
        String first_name_2=faker.name().firstName();
        String last_name_1=faker.name().lastName();
        String last_name_2=faker.name().lastName();
        CustomerUser u1= new CustomerUser(email_1,password_1,first_name_1,last_name_1);
        CustomerUser u2= new CustomerUser(email_2,password_2,first_name_2,last_name_2);

        List<UserDetails> user_list=List.of(u1,u2);
        //Act
        Mockito.when(userRepository.findUserByEmail(email_1)).thenReturn(Optional.of(u1));
        Mockito.when(userRepository.findUserByEmail(email_2)).thenReturn(Optional.of(u2));
        //Assert
        assertEquals(userService.loadUserByUsername(email_1),u1);
        assertEquals(userService.loadUserByUsername(email_2),u2);
    }

}
