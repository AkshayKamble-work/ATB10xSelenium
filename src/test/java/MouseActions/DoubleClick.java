package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DoubleClick {

    WebDriver driver;
@Test
    public  void  TestDouble() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        WebElement loginBtn =driver.findElement(By.xpath("//button[text()='Login']"));
        Actions ac=new Actions(driver);
        ac.doubleClick(loginBtn).perform();
        Thread.sleep(5000);
        driver.quit();

    }
}
