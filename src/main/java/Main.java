import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws Exception {
        WebDriver driver = createDriver();
        driver.get("https://news.google.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        code(driver);
         driver.quit();
    }


    public static WebDriver createDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static void log(String s) {
        System.out.println(s);
    }


    public static void code(WebDriver driver) throws Exception {
        WebElement local;
        local = driver.findElement(By.xpath("//aside"));
        log("Task2");
        new WebDriverWait(driver, 15).until(ExpectedConditions.textToBePresentInElement(local, "Your local weather"));
        log("Task3");
        Assert.assertTrue(driver.findElements(By.xpath("//main/c-wiz/div[1]/div")).size() > 1);
    }
}

