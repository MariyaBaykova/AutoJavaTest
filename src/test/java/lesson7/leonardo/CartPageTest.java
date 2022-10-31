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

public class CartPageTest extends AbstractTest {

    @Test
    @Description("Тест, что при переходе в пустую корзину отображается текст 'Корзина пуста'")
    @Issue("https://leonardo.ru")
    @Severity(SeverityLevel.NORMAL)
    void emptyCart() {
        new MainPage(getWebDriver()).goToCart();
        Assertions.assertEquals("https://leonardo.ru/cart/", getWebDriver().getCurrentUrl());
        Assertions.assertEquals("Корзина пуста", getWebDriver().findElement(By.xpath("//*[text()='Корзина пуста']")).getText());
    }

    @Test
    @Description("Добавление товаров в корзину")
    @Issue("https://leonardo.ru")
    @Severity(SeverityLevel.BLOCKER)
    void addItemsToCart() {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.addQuickToCart(1);
        mainPage.goToCart();
        List<WebElement> cartGoods = getWebDriver().findElements(By.className("cart__goods"));
        Assertions.assertEquals(1, cartGoods.size());
    }

    @Test
    @Description("Удаление товаров из корзины")
    @Issue("https://leonardo.ru")
    @Severity(SeverityLevel.CRITICAL)
    void deleteItemsFromCart() throws InterruptedException {
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage.addQuickToCart(1);
        mainPage.goToCart();
        new CartPage(getWebDriver()).removeCartGoods();
        Thread.sleep(1000);
        getWebDriver().navigate().refresh();
        Assertions.assertEquals("Корзина пуста", getWebDriver().findElement(By.xpath("//*[text()='Корзина пуста']")).getText());
    }

}