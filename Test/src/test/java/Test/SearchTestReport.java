package Test;
 
	import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.AfterClass;
	 
	public class SearchTestReport  {
	public WebDriver driver;
	  @Test
	  public void SearchUser(){
		  // page
	driver.get("http://localhost//covid-tms/patient-search-report.php");
	// Registerd user mobile number
	driver.findElement(By.id("searchdata")).sendKeys("9999999999");
	// Class path 
	driver.findElement(By.xpath("/html/body/div/div/div/div/form/div/div/div/div/div[2]/input")).click();
	//String s=driver.getCurrentUrl();
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
