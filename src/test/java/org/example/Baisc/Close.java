package org.example.Baisc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Close {

@Test
    public  void CloseBrowser() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
