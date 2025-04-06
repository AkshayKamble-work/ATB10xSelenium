package MouseActions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MouseAction {



        WebDriver driver;
        @Test
        public void TestMouse() throws InterruptedException {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://www.onlinemictest.com/keyboard-test/");
            Actions ac=new Actions(driver);
            // Press Ctrl + Shift + Alt together
            ac.keyDown(Keys.CONTROL)
                    .keyDown(Keys.SHIFT)
                    .keyDown(Keys.ALT)
                   // .sendKeys("A") // optional: press a key while holding modifiers
                    .keyUp(Keys.ALT)
                    .keyUp(Keys.SHIFT)
                    .keyUp(Keys.CONTROL)
                    .build()
                    .perform();

            Thread.sleep(5000);
            driver.quit();
        }




}
