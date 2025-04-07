package Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ClosePopIncognito {

@Test
    public  void TestCloseModel()
    {
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy=\"closeModal\"]")));
        WebElement closeModel = driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]"));
        closeModel.click();
        driver.quit();
    }
}
