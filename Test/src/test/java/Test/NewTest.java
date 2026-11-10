package Test;
 
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.AfterClass;
	 
	public class NewTest {
	public WebDriver driver;
	  @Test
	  public void openMyBlog() {
	driver.get("http://localhost/covid-tms/login.php");
	  }
	  
	  @BeforeClass
	  public void beforeClass() {
	  
	  driver = new ChromeDriver();
	  
	  }
	 
	  @AfterClass
	  public void afterClass() {
	  driver.quit();
	  }
	 
	}
