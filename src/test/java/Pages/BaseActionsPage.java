package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class BaseActionsPage {

    protected WebDriver browser;
    protected WebDriverWait waiting;
    protected Actions dii;

    public BaseActionsPage(WebDriver browser) {
        this.browser = browser;
        this.waiting = new WebDriverWait(browser, Duration.ofSeconds(10));
        this.dii = new Actions(browser);
    }

    protected void click(By locator) {
        WebElement element = waiting.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected void typing(By locator, String text) {
        WebElement element = waiting.until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    protected void hoverAndClick(By locator, boolean click) {
        WebElement element = waiting.until(ExpectedConditions.elementToBeClickable(locator));
        if (click) {
            dii.moveToElement(element).click().perform();
        } else {
            dii.moveToElement(element).perform();
        }
    }

    protected void selectMethod(By locator, String text) {
        Select select = new Select(waiting.until(ExpectedConditions.elementToBeClickable(locator)));
        select.selectByVisibleText(text);
    }

    protected void selectWhenOptionLoaded(By locator, String text) {
        waiting.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
        selectMethod(locator, text);
    }

    protected void selectRadioByText(String visibleText) {
        By locator = By.xpath(
                "//label[input[@type='radio' and @name='Order[payment_type]']" +
                        " and contains(normalize-space(),'" + visibleText + "')]//input"
        );
        WebElement radio = waiting.until(ExpectedConditions.elementToBeClickable(locator));
        radio.click();
    }
}


