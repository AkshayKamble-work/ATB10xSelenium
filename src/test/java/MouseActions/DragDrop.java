package MouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragDrop {
    WebDriver driver;

    @Test
    public void TestDragDrop() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable/");
        WebElement draggable = driver.findElement(By.xpath("//div[text()='Drag me']"));
        WebElement dropable = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        Actions ac = new Actions(driver);
        ac.dragAndDrop(draggable, dropable).build().perform();

        driver.quit();
    }
}
