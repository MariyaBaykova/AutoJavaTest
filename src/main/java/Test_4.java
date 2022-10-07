import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test_4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://leonardo.ru/");

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/header/div[2]/div[2]/div/div[3]/div/div[3]/div[1]/a[1]/span"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.id("login"));
        webElement2.click();
        webElement2.sendKeys("testbaykova.ru@yandex.ru");
        WebElement webElement3 = driver.findElement(By.id("password"));
        webElement3.click();
        webElement3.sendKeys("Pass31012022");
        WebElement webElement4 = driver.findElement(By.cssSelector("#loginAuthForm > input[type=submit]"));
        webElement4.click();
    }
}
