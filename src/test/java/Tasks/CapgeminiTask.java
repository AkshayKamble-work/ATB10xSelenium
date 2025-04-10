package Tasks;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CapgeminiTask {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testCapgemini() {
        driver.get("https://www.amazon.in/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            // Click on the hamburger menu (more options)
            WebElement moreOptions = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("nav-hamburger-menu")));
            moreOptions.click();

            // Wait until the sidebar is visible
            WebElement mobileAndPhone = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[text()='Mobiles, Computers']")));
            js.executeScript("arguments[0].scrollIntoView(true);", mobileAndPhone);

            // JavaScript click to avoid intercepted exception
            js.executeScript("arguments[0].click();", mobileAndPhone);

            // Wait for the next menu to be visible
            WebElement allMobilePhone = wait.until(ExpectedConditions.elementToBeClickable(
                    By.linkText("All Mobile Phones")));


            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector("#hmenu-content[aria-hidden='true']")));

            js.executeScript("arguments[0].scrollIntoView(true);", allMobilePhone);
            js.executeScript("arguments[0].click();", allMobilePhone);

            // Click on the Realme phone
            WebElement realmePhone = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//img[@alt='realme 13 Pro 5G (Monet Gold,8GB+128GB)']")));
            js.executeScript("arguments[0].scrollIntoView(true);", realmePhone);
            js.executeScript("arguments[0].click();", realmePhone);

        } catch (Exception e) {
            System.out.println("Test failed due to: " + e.getMessage());
        }
    }


    @AfterTest
    public void closeBrowser() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
