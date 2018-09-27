package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage extends BasePage {

    private static final By sectionElectronics = By.xpath("//li[@data-department='Электроника']");
    private static final By tv = By.xpath("//*[text()='Телевизоры']");
    private static final By headphones = By.xpath("//*[text()='Наушники']");
    private static final By headerSearch = By.xpath("//*[@id='header-search']");

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToElectronicsTV() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(tv));
        WebElement mainMenu = driver.findElement(sectionElectronics);
        WebElement subMenu = driver.findElement(tv);

        driver.findElement(headerSearch).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(mainMenu).build().perform();

        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(subMenu));
        builder.moveToElement(subMenu).click(subMenu).build().perform();
    }

    public void goToElectronicsHeadphones() {
        WebElement mainMenu = driver.findElement(sectionElectronics);
        WebElement subMenu = driver.findElement(headphones);

        driver.findElement(headerSearch).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(mainMenu).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(subMenu));
        builder.moveToElement(subMenu).click(subMenu).build().perform();
    }
}

