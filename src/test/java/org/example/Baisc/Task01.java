package org.example.Baisc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.util.TimeUtils;

import java.time.Duration;

public class Task01 {
@Test
    public void login() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement username=driver.findElement(By.id("txt-username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement loginbtn=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");
        loginbtn.click();
        String currentUrl=driver.getCurrentUrl();
        Assert.assertTrue(true,currentUrl);
    System.out.println(currentUrl);
        Thread.sleep(5000);
        driver.quit();
    }
}
