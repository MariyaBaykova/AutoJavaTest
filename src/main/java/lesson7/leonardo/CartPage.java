package lesson7.leonardo;

import lesson7.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(className = "cart-goods__remove")
    private List<WebElement> cartGoodsRemove;

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public void removeCartGoods() {
        cartGoodsRemove.forEach(WebElement::click);
    }
}
