package lesson7.leonardo;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

class LogInPageTest extends AbstractTest{

    @Test
    @Description("Тест логина и отображения профиля")
    @Issue("https://leonardo.ru")
    @Severity(SeverityLevel.CRITICAL)
    void logIn() throws InterruptedException {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToProfile();
        LogInPage logInPage = new LogInPage(getWebDriver());
        logInPage.logIn("testbaykova.ru@yandex.ru", "Pass31012022");
        Thread.sleep(5000);
        mainPage.goToProfile();

        Assertions.assertEquals("https://leonardo.ru/profile/", getWebDriver().getCurrentUrl());
    }

    @Test
    @Description("Тест ввода пустых логина и пароля")
    @Issue("https://leonardo.ru")
    @Severity(SeverityLevel.CRITICAL)
    void emptyLoginAndPassword() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToProfile();
        LogInPage logInPage = new LogInPage(getWebDriver());
        logInPage.logIn("", "");

        List<WebElement> errors = getWebDriver().findElements(By.xpath("//*[text()='Заполните это поле']"));
        Assertions.assertNotNull(errors);
        Assertions.assertEquals(2, errors.size());
    }

    @Test
    @Description("Тест логина с некорректным email")
    @Issue("https://leonardo.ru")
    @Severity(SeverityLevel.CRITICAL)
    void incorrectLogin() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.goToProfile();
        LogInPage logInPage = new LogInPage(getWebDriver());
        logInPage.logIn("123dsa", "Pass31012022");

        List<WebElement> errors = getWebDriver().findElements(By.xpath("//*[text()='E-mail некорректен']"));

        Assertions.assertNotNull(errors);
        Assertions.assertEquals(1, errors.size());
    }
}