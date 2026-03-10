package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BaseActionsPage {
    private final By nameField = By.id("order-user_name");
    private final By lastNameField = By.id("order-last_name");
    private final By phoneField = By.id("order-telephone");
    private final By regionSelect = By.id("order-postregion");
    private final By citySelect = By.id("order-postcity");
    private final By warehouseSelect = By.id("order-postaddress");
   // private final By radio = By.xpath("//label[input[@type='radio' and @name='Order[payment_type]']" + " and contains(normalize-space(),'" + visibleText + "')]//input");


    public CheckoutPage(WebDriver browser) {
        super(browser);
    }

    public CheckoutPage enterName(String name) {
        typing(nameField, name);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        typing(lastNameField, lastName);
        return this;
    }

    public CheckoutPage enterPhone(String phone) {
        typing(phoneField, phone);
        return this; // а як би зробити так, щоб було нагадування, що не треба вводити +38
    }

    public CheckoutPage chooseRegion(String region) {
        selectMethod(regionSelect, region);
        return this;
    }

    public CheckoutPage chooseCity(String city) {
        selectWhenOptionLoaded(citySelect, city);
        return this;
    }

    public CheckoutPage chooseWarehouse(String warehouse) {
        selectWhenOptionLoaded(warehouseSelect, warehouse);
        return this;
    }

    /*public CheckoutPage choosePayment(String paymentType) {
     selectWhenOptionLoaded(paymentMethodSelect, paymentType);
     return this;
    }*/
    public CheckoutPage choosePayment(String paymentType) {
        selectRadioByText(paymentType);
        return this;
    }

}

