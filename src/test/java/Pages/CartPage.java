package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BaseActionsPage {

    private final By checkoutButton = By.xpath("//a[@class='button' and @href='/checkout']");
    private final By closeCartBtn = By.xpath("//button[contains(@class,'mfp-close')]");

    public CartPage(WebDriver browser) {
        super(browser);
    }

    public CartPage closeCart() {
        click(closeCartBtn);
        return this;           // порада чата для chaining
    }

    public CheckoutPage goToCheckout() {
        click(checkoutButton);
        return new CheckoutPage(browser);
    }
}
