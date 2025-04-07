package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class MouseHover {

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
    public void TestHoverMouse() throws InterruptedException {
        driver.get("https://www.makemytrip.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Handle popup
        try {
            WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("No popup found or already closed.");
        }

        Actions mouse = new Actions(driver);

        // FROM CITY
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        mouse.moveToElement(fromCity).click().sendKeys("Mumbai").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

        // Loop with re-fetch to avoid stale element
        List<WebElement> suggestions;
        for (int i = 0; i < 5; i++) { // retry few times in case of stale
            try {
                suggestions = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
                for (WebElement element : suggestions) {
                    if (element.getText().contains("Mumbai")) {
                        element.click();
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                Thread.sleep(500);
            }
        }
        Thread.sleep(3000);
        // TO CITY
        WebElement toCity = driver.findElement(By.id("toCity"));
        mouse.moveToElement(toCity).click().sendKeys("Pune").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li")));

        for (int i = 0; i < 5; i++) {
            try {
                suggestions = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));
                for (WebElement element : suggestions) {
                    if (element.getText().contains("Pune")) {
                        element.click();
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                Thread.sleep(500);
            }
        }
        WebElement date=driver.findElement(By.xpath("//div[@aria-label='Wed Apr 09 2025']//p[contains(@class,'todayPrice')][normalize-space()='8,524']"));
        date.click();
        Thread.sleep(3000); // Let the TO field become active
        WebElement retun1=driver.findElement(By.xpath("//div[@data-cy=\"returnArea\"]"));
        retun1.click();
        WebElement date1=driver.findElement(By.xpath("//div[@aria-label='Thu May 15 2025']//div[@class='dateInnerCell']"));
        date1.click();
    }

    @AfterTest
    public void CloseBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     driver.quit();
    }
}