package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {
    public static WebDriver driver;

    public static void setDriver(String browser){
        if (browser != null) {
            if (browser.equalsIgnoreCase(BrowserType.GOOGLECHROME)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if (browser.equalsIgnoreCase(BrowserType.FIREFOX_CHROME)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(CommonConstants.TIMEOUT_20S, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
