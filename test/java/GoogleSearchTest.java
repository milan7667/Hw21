import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class GoogleSearchTest {

    String googleUrl = "https://www.google.com/ncr";

    @Test
    public void positiveEnterSearchTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.get(googleUrl);

        driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);

        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));

        System.out.println(stats.getText());

        driver.close();
        driver.quit();
    }

    @Test
    public void positiveButtonSearchTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.get(googleUrl);

         driver.findElement(By.name("q")).sendKeys("cheese");
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
         driver.findElement(By.name("btnK")).click();

        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));

        System.out.println(stats.getText());

        driver.close();
        driver.quit();
    }
}
