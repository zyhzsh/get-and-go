package SystemTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnauthorizedAccessTest {
    WebDriver driver;

    public void openBrowser(String link){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(link);
    }
    public void closeBrowser(){
        driver.close();
    }
    @Test
    public void TryToAccessAdminPageAsAnonymousUser() throws InterruptedException{
        //Arrange The Link
        String link="http://localhost:8080/admin";
        //Act - Open Browser With The Link
        openBrowser(link);
        //Act- Wait for server response
        Thread.sleep(1000);
        //Assert - Check Page Router to the right page
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = "http://localhost:8080/error";
        assertEquals(ActualURL,ExpectedURL);
        closeBrowser();
    }

    @Test
    public void TryToAccessAdminPageAsVendor() throws InterruptedException{
        //Arrange The Link
        String link="http://localhost:8080/signin";
        //Arrange The Registration Data
        String email="test@vendor.com";
        String password="test";
        //Act - Open Browser With The Link
        openBrowser(link);
        //Act - Wait for second
        Thread.sleep(1000);
        //Act - Filled In Email and Password
        driver.findElement(By.id("normal_login_email")).sendKeys(email);
        driver.findElement(By.id("normal_login_password")).sendKeys(password);
        //Act - Submit Registration Form
        driver.findElement(By.tagName("button")).click();
        //Act- Wait for server response
        Thread.sleep(500);
        //Act- Try to visit Admin page
        driver.get("http://localhost:8080/admin");
        Thread.sleep(1000);
        //Assert - Check Page Router to the right page
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = "http://localhost:8080/error";
        assertEquals(ExpectedURL,ActualURL);
        closeBrowser();
    }

    @Test
    public void TryToAccessAdminPageAsCustomer() throws InterruptedException{
        //Arrange The Link
        String link="http://localhost:8080/signin";
        //Arrange The Registration Data
        String email="test@customer.com";
        String password="test";
        //Act - Open Browser With The Link
        openBrowser(link);
        //Act - Wait for second
        Thread.sleep(1000);
        //Act - Filled In Email and Password
        driver.findElement(By.id("normal_login_email")).sendKeys(email);
        driver.findElement(By.id("normal_login_password")).sendKeys(password);
        //Act - Submit Registration Form
        driver.findElement(By.tagName("button")).click();
        //Act- Wait for server response
        Thread.sleep(500);
        //Act- Try to visit Admin page
        driver.get("http://localhost:8080/admin");
        Thread.sleep(1000);
        //Assert - Check Page Router to the right page
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = "http://localhost:8080/error";
        assertEquals(ExpectedURL,ActualURL);
        closeBrowser();
    }

}
