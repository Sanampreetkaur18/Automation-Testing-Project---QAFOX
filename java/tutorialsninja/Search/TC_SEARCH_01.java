package tutorialsninja.Search;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_SEARCH_01 {
	
 
   WebDriver driver;	

	@BeforeMethod
	
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
	}


 @Test
 
 public void verifyListAndGridViewForSearchResult()
 {
	 driver.findElement(By.name("search")).sendKeys("mac");
	 driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	 
	 Assert.assertTrue(driver.findElement(By.id("list-view")).isDisplayed(),"list view button is not displayed");
	 Assert.assertTrue(driver.findElement(By.id("grid-view")).isDisplayed(),"grid view bbutton is not displayed");
	 
	 driver.findElement(By.id("list-view")).click();
	 Assert.assertTrue(driver.findElement(By.cssSelector(".product-layout")).isDisplayed(),"Products are not displayed in list view");
	  
	 driver.findElement(By.id("grid-view")).click();
	 Assert.assertTrue(driver.findElement(By.cssSelector(".product-layout")).isDisplayed(),"Products are not displayed in the grid view");
	 
	 
	
	 
 }
 @AfterMethod
 
 public void teardown() {
	 if(driver!=null)
	 {
		 driver.quit(); 
	 }
 }
 


}



