package Alters;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopUp {
    @Test
    public void TestPoUp() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement ClickAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
        ClickAlert.click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement ClickonConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        ClickonConfirm.click();
        Thread.sleep(5000);
        alert.dismiss();
        ClickonConfirm.click();
        Thread.sleep(5000);
        alert.accept();
        WebElement ClickonPrompt=driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        ClickonPrompt.click();
        Thread.sleep(5000);
        alert.sendKeys("Hello word !!");
        alert.accept();
        driver.quit();
    }
}
