package Tests;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.MainPage;
import Pages.ProductPage;
import org.junit.Test;

public class E2ETest extends InitTest {

    @Test
    public void orderTwoProducts() throws InterruptedException {
        MainPage mainPage = new MainPage(browser);

        ProductPage phoneSamsung = mainPage.search("Samsung").openFirstSpecificProduct();
        CartPage cartPage = phoneSamsung.addToCart();
        cartPage.closeCart();


       CheckoutPage televizor = mainPage.openTVSubCategory().addToCartSecondSpecificProduct().goToCheckout();


        CheckoutPage checkoutPage = new CheckoutPage(browser);
        checkoutPage.enterName("Михайло")
                .enterLastName("Дем'янович")
                .enterPhone("+380988641210")
                .chooseRegion("Рівненська")
                .chooseCity("Рівне")
                .chooseWarehouse("Відділення №37 (до 30 кг на одне місце ): вул. Соборна, 275")
                .choosePayment("Передоплата");
        // переробити
        //   .placeOrder();

        Thread.sleep(5000);
    }
}
