package tutorialsninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_001 {
	
    WebDriver driver;
    
    @BeforeMethod
    public void setup()
    {
    	// Browser name used to support cross-browser testing
    	String browserName="edge";
    	
    	if(browserName.equals("chrome")) 
    	{
    		driver = new ChromeDriver();
    	} 
    	else if (browserName.equals("firefox")) 
    	{
    		driver= new FirefoxDriver();	
    	} 
    	else if (browserName.equals("edge"))
    	{
    		driver = new EdgeDriver();
    	}
    	

        // Basic setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Launch application (FIXED URL – no spaces)
        driver.get("https://tutorialsninja.com/demo/");

        // Navigate to Register page
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
    }
    
    
	@AfterMethod
	public void teardown()
	{
		
		if(driver!=null) // Check if browser is opened before trying to close it (to avoid NullPointerException)
		{
		 driver.quit();	
		}
	}
	
	

    @Test (priority=1)
    public void verifyRegisteringWithMandatoryFields() throws InterruptedException {

        // Fill mandatory fields
        driver.findElement(By.id("input-firstname")).sendKeys("Sanampreet");
        driver.findElement(By.id("input-lastname")).sendKeys("Kaur");
        driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");

        // Agree to privacy policy
        driver.findElement(By.name("agree")).click();

        // Click Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Small wait for success page
        Thread.sleep(2000);// Pause execution for 2000 milliseconds (2 seconds) to wait for page/element to load

        // ===== ASSERTIONS START =====

        // 1. Verify success heading
        String expectedHeading = "Your Account Has Been Created!";
        String actualHeading = driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText();
        Assert.assertEquals(actualHeading, expectedHeading);

        // 2. Verify Logout link is visible
        Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

        // 3. Verify success content text
        String pageText = driver.findElement(By.id("content")).getText();

        Assert.assertTrue(pageText.contains( "Congratulations! Your new account has been successfully created!"));
        Assert.assertTrue(pageText.contains("You can now take advantage of member privileges"));
        Assert.assertTrue(pageText.contains("If you have ANY questions about the operation of this online shop"));
        Assert.assertTrue(pageText.contains("contact us."));

        // Click Continue on success page
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        // 4. Verify My Account page
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());  
       
    }

    // ===== Utility method to generate unique email =====
    public static String generateNewEmail() {

        String emailWithTimeStamp =
                new Date().toString()
                        .replaceAll(" ", "")
                        .replaceAll("\\:", "")
                        + "@gmail.com";

        System.out.println(emailWithTimeStamp);
        return emailWithTimeStamp;
    }
}
