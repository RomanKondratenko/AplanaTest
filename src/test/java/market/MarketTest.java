package market;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.MarketPage;
import pages.CatalogPage;
import pages.ProductPage;

import static driverGenerator.DriverGenerator.createChromeDriver;
import static java.lang.String.*;
import static org.junit.jupiter.api.Assertions.*;

public class MarketTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = createChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMarket();
    }

    @Test
    public void searchForTV() {

        MarketPage marketPage = new MarketPage(driver);
        marketPage.goToElectronicsTV();

        ProductPage productPage = new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersTV();
    }

    @Test
    public void searchForHeadphones() {

        MarketPage marketPage = new MarketPage(driver);
        marketPage.goToElectronicsHeadphones();

        ProductPage productPage = new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersHeadphones();
    }

    @AfterEach
    public void tearDown() {

        ProductPage productPage = new ProductPage(driver);
        assertTrue(productPage.isOfCorrectSize());
        String nameFirstProductInProductPage = productPage.getNameFirstProductInPage();
        productPage.goToSearch();

        CatalogPage catalogPage = new CatalogPage(driver);
        assertEquals(nameFirstProductInProductPage, catalogPage.getNameFirstProductInPage(), format("Критерий поиска не соответствует названию товара: ожидалось [%s], фактическое значение: [%s]", nameFirstProductInProductPage, catalogPage.getNameFirstProductInPage()));

        driver.quit();
    }

}