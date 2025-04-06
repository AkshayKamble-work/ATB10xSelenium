package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MiniProject2 {
@Test
    public  void TestValidations()
    {
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://app.vwo.com/#/login");

        WebElement startFreeTrialLink = driver.findElement(By.linkText("Start a free trial"));
        startFreeTrialLink.click();

        WebElement inputBox = driver.findElement(By.name("email"));
        inputBox.sendKeys("ABC"); // Invalid email

        WebElement checkBox = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        checkBox.click();

        WebElement createFreeAccountButton = driver.findElement(By.xpath("//button[text()='Create a Free Trial Account']"));
        createFreeAccountButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Verify error message
        WebElement errorMessage = driver.findElement(By.xpath("//div[text()='The email address you entered is incorrect.']"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "The email address you entered is incorrect.";
        Assert.assertEquals(actualMessage, expectedMessage, "Error message did not match!");

        driver.quit(); // Close the browser




    }
}
