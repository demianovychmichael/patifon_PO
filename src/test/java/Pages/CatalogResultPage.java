package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogResultPage extends BaseActionsPage {
    private final By secondSpecificProduct = By.xpath("//img[@alt='Телевізор LG 43UR75006LK']//ancestor::div[@class='product']//*[@class='icon-cart']");

    public CatalogResultPage(WebDriver browser) {
        super(browser);
    }
    public CartPage addToCartSecondSpecificProduct() {
        click(secondSpecificProduct);
        return new CartPage(browser);
    }

    }


