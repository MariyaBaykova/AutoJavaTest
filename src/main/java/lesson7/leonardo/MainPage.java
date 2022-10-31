package lesson7.leonardo;

import lesson7.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@href='/profile/']")
    private WebElement profile;

    @FindBy(xpath = "//a[@href='/cart/']")
    private WebElement cart;

    @FindBy(className = "quickcart")
    private List<WebElement> quickCart;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToCart() {
        cart.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://leonardo.ru/cart/"));
    }

    public void addQuickToCart(int limit) {
        quickCart.stream()
                .limit(limit)
                .forEach(webElement -> new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(webElement)).click());
    }

    public void goToProfile() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(profile)).click();
    }
}
