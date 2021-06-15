package SystemTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreManagementTest {
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


    public void LoginAsManager() throws InterruptedException {
        //Arrange The Link
        String link="http://localhost:8080/signin";
        //Arrange The Registration Data
        String email="test@manager.com";
        String password="test";
        //Act - Open Browser With The Link
        openBrowser(link);
        //Act - Wait for second
        //Act - Filled In Email and Password
        driver.findElement(By.id("normal_login_email")).sendKeys(email);
        driver.findElement(By.id("normal_login_password")).sendKeys(password);
        //Act - Submit Registration Form
        driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void OpenStoreManagementPanelTest() throws InterruptedException {
       //Arrange
        LoginAsManager();
        String link="http://localhost:8080/admin";
        Thread.sleep(1000);
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = link;
        assertEquals(ActualURL,ExpectedURL);
        Thread.sleep(1000);
        closeBrowser();
    }
}
