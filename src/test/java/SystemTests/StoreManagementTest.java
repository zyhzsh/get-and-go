package SystemTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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
        //Thread.sleep(1000);
        //Act - Filled In Email and Password
        driver.findElement(By.id("normal_login_email")).sendKeys(email);
        driver.findElement(By.id("normal_login_password")).sendKeys(password);
        //Act - Submit Registration Form
        driver.findElement(By.tagName("button")).click();
    }

    @Test
    public void OpenStoreManagementPanelTest() throws InterruptedException {
        LoginAsManager();
        Thread.sleep(500);
        List<WebElement> menu_btn_s= driver.findElements(By.tagName("li"));
        menu_btn_s.get(1).click();
        Thread.sleep(2000);
        closeBrowser();
    }
}
