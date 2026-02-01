package tutorialsninja.login;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class TC_LOG_02 {

	    WebDriver driver;

	    @BeforeMethod
	    public void setup() {

	        // Step 1: Launch Chrome browser
	        driver = new ChromeDriver();

	        // Step 2: Maximize browser window
	        driver.manage().window().maximize();

	        // Step 3: Apply implicit wait
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Step 4: Open TutorialNinja application
	        driver.get("https://tutorialsninja.com/demo/");

	        // Step 5: Navigate to Login page
	        driver.findElement(By.xpath("//span[text()='My Account']")).click();
	        driver.findElement(By.linkText("Login")).click();
	    }

	    @Test
	    public void verifyPasswordFieldIsMasked() {

	       // Step 6: Locate password field and fetch its type attribute
	        String passwordFieldType = driver.findElement(By.id("input-password")).getAttribute("type");

	        // Step 7: Verify password field is masked
	        Assert.assertEquals(passwordFieldType,"password","Password field is not masked"); //(actual, expected, failure message)
	    }

	    @AfterMethod
	    public void tearDown() {

	        // Step 8: Close browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	} 



