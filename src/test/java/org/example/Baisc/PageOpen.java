package org.example.Baisc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageOpen {


    @Test
    public  void GetMethod()
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");


    }
}
