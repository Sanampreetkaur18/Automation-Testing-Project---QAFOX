
package tutorialsninja.productCompare;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_PC_01 {

    WebDriver driver;
    WebDriverWait wait;// declare wait globally

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));// Explicit wait: Selenium will wait up to 10 seconds for a condition before failing

        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.name("search")).sendKeys("mac");
        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
    }

    @Test
    public void verifyAddProductToCompareFromProductDisplayPage() {

        // Click product
        driver.findElement(By.linkText("iMac")).click();

        // Click compare button
        driver.findElement(By.xpath("//button[@data-original-title='Compare this Product']")).click();

        // Wait for success message
        WebElement successmsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success"))
        );

        // Assertion
        Assert.assertTrue(successmsg.isDisplayed(), "Product is not added to compare");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

