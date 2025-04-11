package Exceptions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class StaleElementException {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

@Test
    public void TestException()
    {

        driver.get("https://google.com");
        System.out.println("Start of program");

        WebElement search_input_box  = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        System.out.println(driver.getWindowHandle());

        driver.navigate().refresh();

        try {
            search_input_box.sendKeys("the testing academy"+ Keys.ENTER);
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException");
        }
        // org.openqa.selenium.StaleElementReferenceException: stale element reference: stale element not found


        System.out.println(driver.getWindowHandle());
        System.out.println("End of program");

    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
