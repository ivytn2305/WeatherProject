package com.auto.openweather.ui.tests;

import common.BaseTest;
import common.WebDriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SearchResultPage;
import utils.ExcelDataProvider;

public class SearchWeatherInYourCityTests extends BaseTest {

    @Test(dataProvider = "testData", dataProviderClass = ExcelDataProvider.class)
    @Description("TC01 - Search Weather Using Comnination of City Name and Country Code")
    @Feature("Search Weather In Your City")
    @Severity(SeverityLevel.CRITICAL)
    public void TC01_SearchWeatherUsingCombinationOfCityNameAndCountryCode(String searchKeyword, String homePageExpectedPageTitle, String searchResultPageExpectedPageTitle){
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        //1. Navigate to Home Page
        WebDriverFactory.getDriver().get("https://openweathermap.org/");

        //2. Search a city using Combination Of City Name And Country Code
        homePage.searchWeatherForACity(searchKeyword, homePageExpectedPageTitle);

        //3. Verify search result
        searchResultPage.verifyDataReturnedOnSearchResultPage(searchKeyword, searchResultPageExpectedPageTitle);

    }

    @Test(dataProvider = "testData", dataProviderClass = ExcelDataProvider.class)
    @Description("TC02 - Search Weather From Search Result Page")
    @Feature("Search Weather In Your City")
    @Severity(SeverityLevel.NORMAL)
    public void TC02_SearchWeatherFromSearchResultPage(String searchKeyword, String homePageExpectedPageTitle, String searchResultPageExpectedPageTitle, String searchKeywordOnSearchResultPage){
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        //1. Navigate to Home Page
        WebDriverFactory.getDriver().get("https://openweathermap.org/");

        //2. Search a city to go to Search Result page
        homePage.searchWeatherForACity(searchKeyword, homePageExpectedPageTitle);

        //3. Search from Search Result Page
        searchResultPage.searchFromSearchResultPage(searchKeywordOnSearchResultPage);

        //3. Verify search result
        searchResultPage.verifyDataReturnedOnSearchResultPage(searchKeywordOnSearchResultPage, searchResultPageExpectedPageTitle);

    }
}
