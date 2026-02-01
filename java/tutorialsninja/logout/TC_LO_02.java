package tutorialsninja.logout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_LO_02 {
	
	
	WebDriver driver;

	@BeforeMethod
	
	public void setup() {
	
		driver = new ChromeDriver(); // launch chromedriver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
	}
	
	@Test
	
	public void verifyLogoutButtonUI()
	{
		
		driver.findElement(By.id("input-email")).sendKeys("sanamkaur354@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Sanam@12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Step 1: Wait for Logout button to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));

	//step 1 logout is displayed
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed(),"logout button is not dispalyed");
		
	// step 2 logout is enabled
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isEnabled(),"logout button is not enabled");
		
	//step 3 
		
		String fontSize = driver.findElement(By.linkText("Logout")).getCssValue("font-size");
		Assert.assertEquals(fontSize,"12px","Font size of logout button is mismatched");
		
		
	}

	
	@AfterMethod
	
	public void teardown() {
		
		if (driver!=null) {
	driver.quit();// close browser
		}
	}
}

 

 
