package org.example.Baisc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Options {
    @Test
    public  void TestOptions() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Required for Windows OS
        options.addArguments("--window-size=1920,1080"); // Set window size (optional)
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        System.out.println("opened herokup site");
        driver.navigate().to("https://www.google.com");
        System.out.println("opened Googel com  site");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);
        driver.quit();
    }

}
