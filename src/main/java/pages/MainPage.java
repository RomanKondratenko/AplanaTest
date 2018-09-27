package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    private static final By yandexMarket = By.xpath("//*[@data-id='market']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToMarket() {

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(yandexMarket));
        driver.findElement(yandexMarket).click();
    }
}
