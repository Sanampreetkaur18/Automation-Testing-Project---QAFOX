package tutorialsninja.register;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class TC_RF_002 {
	
	
	
	
	@Test
	public void verifyNavigatingToRegisterAccountUsingMultipleWay() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		//First Way of Navigating
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		//2nd way of navigation
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
		//3rd way of navigating
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());
		
	driver.quit();
	}

}
