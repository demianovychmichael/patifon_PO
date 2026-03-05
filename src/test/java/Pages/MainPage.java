package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends BaseActionsPage {

    private final By searchField = By.id("search-input");
    private final By searchButton = By.className("button--search");
    private final By catalogMenu = By.xpath("//a[contains(@class,'header__catalog') and contains(., 'Каталог товарів')]");
    private final By categoryTvPhoto = By.xpath("//a[@class='nav__link' and @href='/catalog/televizori-foto-video']" );      //a[text()='Телевізори, фото, відео']
    private final By subCategoryTv = By.xpath("//ul[contains(@class, 'nav__list')]//a[contains(@href, '/catalog/televizori-foto-video/televizorivideopleeri/televizori')]");  //a[contains(@href,'televizorivideopleeri/televizori')]

    public MainPage(WebDriver browser) {
        super(browser);
    }

    public SearchResultPage search(String zapit) {
        typing(searchField, zapit);
        click(searchButton);
        return new SearchResultPage(browser);
    }

    public CatalogResultPage openTVSubCategory() {
        hoverAndClick(catalogMenu, false);
        hoverAndClick(categoryTvPhoto, false);
        hoverAndClick(subCategoryTv, true);
        return new CatalogResultPage(browser);
    }

    // Додатковий гнучкий метод (залишив для майбутньої параметризації)
//    public CatalogResultPage openCategory(String categoryXPath) {
//        hoverAndClick(catalogMenu, false);
//        hoverAndClick(By.xpath(categoryXPath), true);
//        return new CatalogResultPage(browser);
    }
}
