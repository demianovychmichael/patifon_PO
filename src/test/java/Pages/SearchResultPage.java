package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage extends BaseActionsPage {
    private final By firstSpecificProduct = By.xpath("//img[@alt='Samsung A566 Galaxy A56 8/256Gb (Awesome Light Gray) EU  - Міжнародний']//ancestor::div[@class='product']");

    public SearchResultPage(WebDriver browser) {
        super(browser);
    }

    public ProductPage openFirstSpecificProduct() {
        click(firstSpecificProduct);
        return new ProductPage(browser);
    }
}
