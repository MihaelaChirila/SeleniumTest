import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowserScript {

    WebDriver driver;

    @Parameters("browser")
    @BeforeTest

    public void setup(String browser) throws Exception {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\SeleniumDrivers\\ms edge driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void mytest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://localhost:81/wordpress/wp-login.php?loggedout=true&wp_lang=en_US");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("user_login")).sendKeys("mihaela");
        driver.findElement(By.id("user_pass")).sendKeys("kim955sen988");
        driver.findElement(By.id("wp-submit")).click();


        driver.findElement(By.className("wp-menu-name")).click();
        driver.findElement(By.className("wp-first-item current")).click();
        driver.findElement(By.className("button button-primary customize load-customize hide-if-no-customize")).click();
        Thread.sleep(5000);
    }
}
