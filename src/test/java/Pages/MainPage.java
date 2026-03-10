package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BaseActionsPage {

    private final By searchField = By.id("search-input");
    private final By searchButton = By.className("button--search");
    private final By mainMenu = By.xpath("//a[contains(@class,'header__catalog') and contains(., 'Каталог товарів')]");
    private final By categoryTvPhoto = By.xpath("//a[@class='nav__link' and @href='/catalog/televizori-foto-video']");      //a[text()='Телевізори, фото, відео']
    private final By subCategoryTv = By.xpath("//ul[contains(@class, 'nav__list')]//a[contains(@href, '/catalog/televizori-foto-video/televizorivideopleeri/televizori')]");  //a[contains(@href,'televizorivideopleeri/televizori')]

    public MainPage(WebDriver browser) {
        super(browser);
    }

    public SearchResultPage search(String zapit) {
        typing(searchField, zapit);
        click(searchButton);
        return new SearchResultPage(browser);
    }

    public CatalogResultPage openSubCategory() {
       hoverAndClick(mainMenu, false);
       hoverAndClick(categoryTvPhoto, false);
       hoverAndClick(subCategoryTv, true);
       return new CatalogResultPage(browser);
     }    // треба переробити, щоб можна було обирати категорію на глибину за доп циклу

    public CatalogResultPage openCategory(String categoryXPath, String subCategoryXPath) {
        hoverAndClick(mainMenu, false);
        hoverAndClick(By.xpath(categoryXPath), false);
        hoverAndClick(By.xpath(subCategoryXPath), true);
        return new CatalogResultPage(browser);
    } // локатори в тесті в мене були через цей метод

    // --- Альтернативний універсальний метод через текст категорії ---
    public CatalogResultPage openCategoryByName(String mainCategoryName, String subCategoryName) {
        hoverAndClick(mainMenu, false);
        hoverAndClick(By.xpath("//a[contains(text(),'" + mainCategoryName + "')]"), false);
        hoverAndClick(By.xpath("//a[contains(text(),'" + subCategoryName + "')]"), true);
        return new CatalogResultPage(browser);
    }
// ідея шикарна, але чи буде працювати?

}





