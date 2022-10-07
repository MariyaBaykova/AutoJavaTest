import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Test_3 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://leonardo.ru/");

        WebElement webElement1 = driver.findElement(By.xpath("/html/body/header/div[2]/div[2]/div/div[2]/div[1]/div[1]/a/span"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div/ymaps/ymaps[6]/ymaps[12]/ymaps/ymaps/ymaps"));
        webElement2.click();
    }
}
