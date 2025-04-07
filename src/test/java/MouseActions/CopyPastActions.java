package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CopyPastActions {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser()
    {
        driver=new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void TestCopyPast() throws InterruptedException {
        driver.get("https://www.facebook.com/");
       WebElement emailbox=driver.findElement(By.id("email"));
       emailbox.sendKeys("ABC@123");
       WebElement passwordbox=driver.findElement(By.id("pass"));
        Actions action=new Actions(driver);
        action.doubleClick(emailbox).perform();
        Actions actions = new Actions(driver);
        // Select all and copy (COMMAND+A, COMMAND+C on Mac)
        action.click(emailbox)
                .keyDown(Keys.ALT).sendKeys("a").keyUp(Keys.ALT)
                .keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT)
                .perform();

        Thread.sleep(1000); // wait to ensure copy is complete
        passwordbox.click();

        // Paste into password field (COMMAND+V on Mac)
        action.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).perform();

        Thread.sleep(1000); // wait to ensure paste is complete

        // ✅ Get and print the value pasted into the password field
        String pastedValue = passwordbox.getAttribute("pass");
        System.out.println("Pasted into password field: " + pastedValue);
    }

    @AfterTest
    public  void CloseBrowser()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
