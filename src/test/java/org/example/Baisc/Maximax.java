package org.example.Baisc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Maximax {

    @Test
    public  void MaximaxBrowser() throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.quit();
    }
}
