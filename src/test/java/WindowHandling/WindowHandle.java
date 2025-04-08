package WindowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WindowHandle {

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
    public void TestWindowHandles() throws InterruptedException {
        driver.get("https://demo.automationtesting.in/Windows.html");

        driver.findElement(By.xpath("//a[text()='Open New Seperate Windows']")).click();
        // Store the parent window handle before clicking
        String parentWindow = driver.getWindowHandle();

        // Click to open new window
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='click']"));
        Thread.sleep(5000);
        clickButton.click();

        // Wait briefly to let the new window open
        Thread.sleep(2000);

        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                // Switch to child window
                driver.switchTo().window(window);

                // Do your action in child window
                System.out.println("Switched to child window: " + driver.getTitle());

                // Close the child window
                driver.close();
            }
        }
        // Switch back to parent
        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to parent: " + driver.getTitle());
    }

    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
