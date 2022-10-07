import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test_1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://leonardo.ru/");


            WebElement webElement1 = driver.findElement(By.xpath("/html/body/header/div[2]/div[2]/div/div[2]/div[2]/form/div/div/input"));
            webElement1.sendKeys("корзинка");
            webElement1.sendKeys(Keys.RETURN);



    }
}
