package Check_Radio_InputBox;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckBox_RadioBox_InputBox {
    @Test
    public  void TestBoxs() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://awesomeqa.com/practice.html");
        // Radio button
        WebElement female=driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]"));
        WebElement male =driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]"));
        female.click();
        Thread.sleep(2000);
        male.click();
        WebElement ManualTester=driver.findElement(By.xpath("//input[@value=\"Manual Tester\"]"));
        WebElement AutomationTester=driver.findElement(By.xpath("//input[@value=\"Automation Tester\"]"));
    ManualTester.click();
        Thread.sleep(2000);
        AutomationTester.click();
        driver.quit();

    }
}
