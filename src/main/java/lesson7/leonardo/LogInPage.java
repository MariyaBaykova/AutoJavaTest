package lesson7.leonardo;

import lesson7.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LogInPage extends AbstractPage {

    @FindBy(name = "login")
    private WebElement login;

    @FindBy(name = "pass")
    private WebElement password;

    @FindBy(css = "#loginAuthForm > button")
    private WebElement submit;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String login, String password) {
//        this.login.click();
        this.login.sendKeys(login);
//        this.password.click();
        this.password.sendKeys(password);
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(submit)).click();
    }
}
