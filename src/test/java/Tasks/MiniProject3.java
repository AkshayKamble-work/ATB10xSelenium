package Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MiniProject3 {
@Test
    public  void Test()
    {
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement Makeappointment =driver.findElement(By.xpath("//a[contains(text(),'Make Appointment')]"));
Makeappointment.click();
WebElement usernameinputbox=driver.findElement(By.xpath("//input[@placeholder=\"Username\" and @name='username']"));
WebElement passwordinputbox=driver.findElement(By.xpath("//input[@placeholder=\"Password\" and @name='password']"));
usernameinputbox.sendKeys("John Doe");
passwordinputbox.sendKeys("ThisIsNotAPassword");
WebElement loginButton=driver.findElement(By.id("btn-login"));
loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/profile.php#login");


driver.quit();













    }
}
