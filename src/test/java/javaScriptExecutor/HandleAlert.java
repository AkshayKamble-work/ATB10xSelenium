package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleAlert {

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
    public void TestScrollIntoView() throws InterruptedException {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(5000);
        WebElement element=driver.findElement(By.xpath("//button[text()='Click To Open Window Prompt Alert']"));
        WebElement element1=driver.findElement(By.xpath("//h2[text()='Subscribe to our youtube channel']"));


        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
        Thread.sleep(5000);
        js.executeScript("arguments[0].scrollIntoView(true)",element1);
        Thread.sleep(5000);
        js.executeScript("alert(1)");


    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
