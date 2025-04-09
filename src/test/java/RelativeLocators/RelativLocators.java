package RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativLocators {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void TestLocators() throws InterruptedException {
        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");
        WebElement searchbox = driver.findElement(By.xpath("(//input[@type=\"search\"])[2]"));
        searchbox.sendKeys("india"+ Keys.ENTER);
Thread.sleep(5000);
        List<WebElement> Alllocation=driver.findElements(By.cssSelector("div.location-name>p"));
        for(WebElement locations:Alllocation) {
            String rank = driver.findElement(with(By.tagName("p")).toLeftOf(locations)).getText();
            String aqi = driver.findElement(with(By.tagName("p")).toLeftOf(locations)).getText();
            System.out.println("| +" + rank + " | " + locations.getText() + " | " + aqi + " | ");
        }
    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
