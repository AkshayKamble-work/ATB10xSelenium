package TablesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class TablesHandling {
WebDriver driver;
@Test
    public void TestTableData() {
    try {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://awesomeqa.com/webtable.html");

        // Get number of rows
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        // Get number of columns from the first row
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")).size();

        for (int i = 2; i <= row; i++)
        { // i starts from 2 to skip header
            for (int j = 1; j <= col; j++)
            {
                String data = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(data + " | ");
            }
            System.out.println(); // New line after each row
        }
    } finally {
        driver.quit();
    }
}
    }
