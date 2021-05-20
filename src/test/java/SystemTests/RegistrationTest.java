package SystemTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

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
    public void RegistrationMissingInformationTest() throws InterruptedException{
        //Arrange The Link
        String link="http://localhost:8080/signup";
        //Arrange The Registration Data
        String email="wjzyhzsh@outlook.com";
        String password="test";
        String first_name="S";
        //Act - Open Browser With The Link
        openBrowser(link);
        //Act - Wait for second
        Thread.sleep(1000);
        //Act - Filled In Registration Form Missing One Parameter
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("first_name")).sendKeys(first_name);
        //Act - Submit Registration Form
        driver.findElement(By.tagName("button")).click();
        //Act- Wait for server response
        Thread.sleep(3000);
        //Assert - Check Page Router to the right page
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = link;
        assertEquals(ActualURL,ExpectedURL);
        closeBrowser();
    }

    @Test
    public void RegistrationHappyFlowTest() throws InterruptedException {
        //Arrange The Link
        String link="http://localhost:8080/signup";

        //Arrange The Registration Data
        String email="wjzyhzsh@outlook.com";
        String password="test";
        String first_name="S";
        String last_name="Zhu";

        //Act - Open Browser With The Link
        openBrowser(link);
        //Act - Wait for second
        Thread.sleep(1000);
        //Act - Filled In Registration Form
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("first_name")).sendKeys(first_name);
        driver.findElement(By.id("last_name")).sendKeys(last_name);
        //Act - Submit Registration Form
        driver.findElement(By.tagName("button")).click();
        //Act- Wait for server response
        Thread.sleep(3000);

        //Assert - Check Page Router to the right page
        String ActualURL = driver.getCurrentUrl();
        String ExpectedURL = "http://localhost:8080/signin";
        assertEquals(ActualURL,ExpectedURL);
        closeBrowser();
    }

}
