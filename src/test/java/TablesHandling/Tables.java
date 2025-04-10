package TablesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tables {


    WebDriver driver;

    @Test
    public void TestTableData() {
        try {
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://awesomeqa.com/webtable.html");

            String first = "//table[@id='customers']/tbody/tr[";
            String second = "]/td[";
            String third = "]";

            // Get number of rows
            int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
            // Get number of columns from the header
            int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th")).size();

            for (int i = 2; i <= row; i++) { // skip header (starts from row 2)
                for (int j = 1; j <= col; j++) {
                    String dynamicXpath = first + i + second + j + third;
                    String tableData = driver.findElement(By.xpath(dynamicXpath)).getText();
                    System.out.print(tableData + " || ");
                }
                System.out.println(); // New line after each row
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}