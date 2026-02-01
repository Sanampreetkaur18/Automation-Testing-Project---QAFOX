package tutorialsninja.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_LOG_01 {

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
    public void verifyLoginWithValidCredentials() {

        // Step 6: Enter REGISTERED email address
        driver.findElement(By.id("input-email"))
              .sendKeys("sanamkaur354@gmail.com");   // use registered email

        // Step 7: Enter correct password
        driver.findElement(By.id("input-password"))
              .sendKeys("Sanam@12345");                // use registered password

        // Step 8: Click on Login button
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Step 9: Verify My Account page is displayed
        Assert.assertTrue(
                driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed(),
                "Login failed - My Account page not displayed"
        );
    }

    @AfterMethod
    public void tearDown() {

        // Step 10: Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
