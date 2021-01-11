package common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void initDriver(@Optional String browser) {
        WebDriverFactory.setDriver(browser);
        driver = WebDriverFactory.getDriver();
    }

    @AfterMethod
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
    }
}
