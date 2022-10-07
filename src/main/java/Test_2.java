import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test_2 {

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
        WebElement webElement2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[3]/div[2]/a"));
        webElement2.sendKeys(Keys.RETURN);
        WebElement webElement3 = driver.findElement(By.xpath("/html/body/header/div[2]/div[2]/div/div[3]/div/div[3]/div[3]/a/span"));
        webElement3.click();




    }
}
