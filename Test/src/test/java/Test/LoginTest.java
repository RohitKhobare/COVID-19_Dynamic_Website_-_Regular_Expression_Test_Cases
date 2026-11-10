package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class LoginTest {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void Login() {

        driver.get("http://localhost/covid-tms/login.php");

        String username = System.getenv("COVID_TMS_ADMIN_USERNAME");
        String password = System.getenv("COVID_TMS_ADMIN_PASSWORD");
        Assert.assertNotNull(username, "Set COVID_TMS_ADMIN_USERNAME for this local test.");
        Assert.assertNotNull(password, "Set COVID_TMS_ADMIN_PASSWORD for this local test.");

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("inputpwd")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        // optional validation
        System.out.println(driver.getCurrentUrl());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
