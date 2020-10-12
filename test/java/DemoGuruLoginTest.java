import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class DemoGuruLoginTest {
    WebDriver driver;
    WebDriverWait wait;
    String baseUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String validLogin = "1303";

    @BeforeSuite
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void positiveLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys(validLogin);
        driver.findElement(By.name("password")).sendKeys("Guru99");

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        WebElement logoutButton = wait.until(presenceOfElementLocated(By.linkText("Log out")));
        logoutButton.click();
        assertEquals(driver.switchTo().alert().getText(), "You Have Succesfully Logged Out!!");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);
        driver.close();

    }

    @Test
    public void negative1WrongPasswordLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys(validLogin);
        driver.findElement(By.name("password")).sendKeys("Guru9");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);
        driver.close();

    }

    @Test
    public void negative2EmptyLoginLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys(" ");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);
        driver.close();


    }

    @Test
    public void negative3EmptyPasswordValueLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys(validLogin);
        driver.findElement(By.name("password")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);
        driver.close();


    }

    @Test
    public void negative4NotValidLoginPasswordValueLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys("1");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);
        driver.close();


    }

    @Test
    public void negative5DoNotClickLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys("validLogin");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        //driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        //assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        //driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);
        driver.close();


    }

    @Test
    public void negative6EmptyLoginAndPasswordLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.findElement(By.name("uid")).sendKeys(" ");
        driver.findElement(By.name("password")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);


    }

    @Test
    public void negative7WithoutLoginLoginTest() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        //driver.findElement(By.name("uid")).sendKeys(" ");
        driver.findElement(By.name("password")).sendKeys(" ");
        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
        assertEquals(driver.getCurrentUrl(), baseUrl);


    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }


        @AfterSuite
        public void tearDown() {
        driver.quit();
        }

    }

