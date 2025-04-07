package Waits;


import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void TestErrorMessage() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");
        WebElement usernametextbox = driver.findElement(By.cssSelector("#login-username"));
        WebElement passwordtextbox = driver.findElement(By.cssSelector("#login-password"));
        usernametextbox.sendKeys("Admin@123");
        passwordtextbox.sendKeys("Password@1122");

        WebElement loginButton = driver.findElement(By.cssSelector("button#js-login-btn"));
        loginButton.click();
        WebElement ErrorMessage = driver.findElement(By.cssSelector("div#js-notification-box-msg"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0xa));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#js-notification-box-msg")));
        Assert.assertEquals(ErrorMessage.getText(), "Your email, password, IP address or location did not match");
        Thread.sleep(5000);
        driver.quit();
    }
}
