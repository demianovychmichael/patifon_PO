package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class InitTest {
    protected WebDriver browser;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://patifon.ua/");
    }

    @After
    public void tearDown() {
        if (browser !=null) {
        browser.quit();}
    }

}


