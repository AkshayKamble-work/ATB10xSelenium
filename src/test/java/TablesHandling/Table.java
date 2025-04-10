package TablesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Table {


    WebDriver driver;


    @BeforeTest
    public void OpenBrowser() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


@Test
public void TestTable()
{
    driver.get("https://www.w3schools.com/html/html_tables.asp");
    WebElement table = driver.findElement(By.id("customers"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));

    for (WebElement row : rows) {
        List<WebElement> cols = row.findElements(By.tagName("td"));
        for (WebElement col : cols) {
            System.out.print(col.getText() + " |  ");
        }
        System.out.println();
    }
}



    @AfterTest
    public void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
