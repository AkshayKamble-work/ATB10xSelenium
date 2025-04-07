package SVG_Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WordMap {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @Test
    public void TestWordMap() throws InterruptedException {
        String URL = "https://www.amcharts.com/svg-maps/?map=worldIndia";
        driver.get(URL);

        Thread.sleep(3000); // Wait for the SVG map to load

        // Locate SVG paths for the countries on the map
        List<WebElement> worldMap = driver.findElements(By.xpath(
                "//*[name()='svg']/*[name()='g']/*[name()='g']/*[name()='g'][1]/*[name()='path']"
        ));

        for (WebElement mapElement : worldMap) {
            String label = mapElement.getDomAttribute("aria-label");
            System.out.println(label);
            if (label != null && label.contains("Sudan")) {
                try {
                    mapElement.click();
                    System.out.println("Clicked on: " + label);
                } catch (Exception e) {
                    System.out.println("Unable to click on: " + label);
                }
            }
        }
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(7000); // Just for observation before closing
        if (driver != null) {
            driver.quit();
        }
    }
}
