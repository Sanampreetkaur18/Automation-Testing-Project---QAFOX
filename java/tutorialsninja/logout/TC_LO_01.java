package tutorialsninja.logout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_LO_01 {
	
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
		public void verifyLogoutAndLoginAgain() {

		    // Login
		    driver.findElement(By.id("input-email")).sendKeys("sanamkaur354@gmail.com");
		    driver.findElement(By.id("input-password")).sendKeys("Sanam@12345");
		    driver.findElement(By.xpath("//input[@value='Login']")).click();

		    // Verify login success
		    Assert.assertTrue(
		        driver.findElement(By.linkText("My Account")).isDisplayed(),
		        "Login failed"
		    );

		    // Logout
		    driver.findElement(By.linkText("Logout")).click();

		    // Verify logout page
		    Assert.assertTrue(
		        driver.findElement(By.xpath("//h1[text()='Account Logout']")).isDisplayed(),
		        "Logout page not displayed"
		    );

		    // ✅ Correct step after logout
		    driver.findElement(By.xpath("//a[text()='Continue']")).click();

		    // Verify home page
		    Assert.assertTrue(
		        driver.findElement(By.id("logo")).isDisplayed(),
		        "Home page not displayed"
		    );

		    // Go to Login again (proper way)
		    driver.findElement(By.xpath("//span[text()='My Account']")).click();
		    driver.findElement(By.xpath("//a[text()='Login']")).click();

		    // Verify Returning Customer section
		    Assert.assertTrue(
		        driver.findElement(By.xpath("//h2[text()='Returning Customer']")).isDisplayed(),
		        "Login page not displayed after logout"
		    );
		}


@AfterMethod

public void teardown()
{
	
	if(driver!=null) 
	{
	 driver.quit();	
	}
}
}
