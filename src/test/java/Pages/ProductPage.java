package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BaseActionsPage {
    private final By addToCartButton = By.xpath("//div[contains(@class, 'details__buy-button')]");  //div[@class='details__buy-button active']//a[contains(@class,'button')]

    public ProductPage(WebDriver browser) {
        super(browser);
    }


    public CartPage addToCart() {
        click(addToCartButton);
        return new CartPage(browser);
    }
}


