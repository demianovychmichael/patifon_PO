package Pages;

import org.openqa.selenium.WebDriver;

public class PurchaseFlow {

    private WebDriver browser;

    public PurchaseFlow(WebDriver browser) {
        this.browser = browser;
    }

    public void purchaseTwoProducts(String firstProductSearch,
                                    String name,
                                    String lastName,
                                    String phone,
                                    String region,
                                    String city,
                                    String warehouse,
                                    String paymentType) {

        MainPage mainPage = new MainPage(browser);

        CartPage firstProduct = mainPage.search(firstProductSearch)
                .openFirstSpecificProduct()
                .addToCart()
                .closeCart();

        CartPage secondProduct = mainPage.openSubCategory()
                .addToCartSecondSpecificProduct();   // чат порадив не закривати кошик

        CheckoutPage checkout = secondProduct.goToCheckout();  // чат порадив не чейнити тут, а зробити розрив, щоб завантажилась сторінка
        checkout.enterName(name)
                .enterLastName(lastName)
                .enterPhone(phone)
                .chooseRegion(region)
                .chooseCity(city)
                .chooseWarehouse(warehouse)
                .choosePayment(paymentType);
    }

}
