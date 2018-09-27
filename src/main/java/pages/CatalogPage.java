package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage extends BasePage {

    private static final By mainHeader = By.xpath("//h1");
    private static final By nameFirstProductInPage = By.xpath("//*[contains(@class, 'n-snippet-list ')]/div[1]//div[contains(@class, 'title')]//a");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNameFirstProductInPage() {
        try {
            return driver.findElement(nameFirstProductInPage).getText();
        } catch (Exception e) {
            return driver.findElement(mainHeader).getText();
        }
    }
}