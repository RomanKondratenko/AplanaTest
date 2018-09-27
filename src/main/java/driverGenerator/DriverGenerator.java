package driverGenerator;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGenerator {

    public static ChromeDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", DriverGenerator.class.getClassLoader().getResource("chromedriver.exe").getFile());
        return new ChromeDriver();
    }
}