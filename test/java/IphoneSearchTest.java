import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class IphoneSearchTest {

    String googleUrl = "https://www.google.com/ncr";
    WebDriver driver;
    WebDriverWait wait;


    @BeforeSuite
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void positiveButtonSearchTest() {
        driver.get(googleUrl);

        driver.findElement(By.name("q")).sendKeys("iphone kyiv buy" + Keys.ENTER);
        wait = new WebDriverWait(driver, 10);


        List<WebElement> elements = driver.findElements(By.xpath("cite class"));
        for (WebElement element : elements) {
            System.out.println(" text:" + element.getText());


        }
    }
}
