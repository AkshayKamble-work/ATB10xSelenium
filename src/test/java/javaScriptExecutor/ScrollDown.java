package javaScriptExecutor;

import io.opentelemetry.sdk.trace.data.ExceptionEventData;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollDown {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--incognito");
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TestScroll() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Handle popup
        try {
            WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("No popup found or already closed.");
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 80000);");
        js.executeScript("window.scrollBy(0, 80000);");
        Thread.sleep(8000);
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='Flagship Hotel Stores on MakeMyTrip']")));
        WebElement element = driver.findElement(By.xpath("//p[text()='Flagship Hotel Stores on MakeMyTrip']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
