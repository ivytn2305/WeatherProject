package pageobjects;

import common.BasePage;
import common.CommonConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {
    @FindBy(css = "#q")
    WebElement searchInput;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchWeatherForACity(String searchKeyword, String expectedPageTitle){
        //Wait for page load
        waitForPageLoad();

        //Verify page title is correct
       Assert.assertEquals(getPageTitle(), expectedPageTitle);

        //Enter keyword to search field and perform search
        waitForElementToBeClickable(searchInput);
        searchInput.sendKeys(searchKeyword);
/*        try {
            Thread.sleep(CommonConstants.TIMEOUT_20S);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        searchInput.sendKeys(Keys.ENTER);
    }

}
