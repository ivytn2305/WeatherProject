package pageobjects;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResultPage extends BasePage {
    @FindBy(xpath = "//div[label[.='Search']]//input")
    WebElement searchInput;

    @FindBy(xpath = "//button[normalize-space(.)='Search']")
    WebElement searchButton;

    @FindBy(css = "#forecast_list_ul")
    WebElement resultText;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyDataReturnedOnSearchResultPage(String searchKeyWord, String expectedPageTitle) {
        //Wait for page load
        waitForPageLoad();

        //Verify page title is correct
        Assert.assertEquals(getPageTitle(), expectedPageTitle);

        //Verify search keyword is persisted on the Search Input
        waitForElementToBePresentedOnPage(searchInput);
        Assert.assertEquals(searchInput.getAttribute("value"), searchKeyWord);

        //Verify cities returned matches with the search keyword
        String keywordList[] = searchKeyWord.split(",");
        int numOfCitiesReturned = driver.findElements(By.xpath("//table//tbody//tr")).size();

        if (numOfCitiesReturned > 0) {
            for (int i = 1; i <= numOfCitiesReturned; i++) {
                String cityLocator = String.format("//tr[%s%s", i, "]//img//preceding-sibling::b//a[1]");
                String cityNameInResultList = driver.findElement(By.xpath(cityLocator)).getText();
                for (String keyword : keywordList) {
                    Assert.assertTrue(cityNameInResultList.contains(keyword.trim()));
                }
            }
        } else {
            Assert.assertEquals(resultText.getText().substring(1).replace("\n", ""), "Not found");
        }

    }

    public void searchFromSearchResultPage(String searchKeyWord) {
        searchInput.clear();
        searchInput.sendKeys(searchKeyWord);
        searchButton.click();
        waitForElementToBePresentedOnPage(resultText);
    }


}
