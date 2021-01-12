#Steps to run the project:
1. Clone code from https://github.com/ivytn2305/WeatherProject.git
2. Open the project using your IDE, eg: Intellij
3. Expand the WeatherProject
4. Right click on the testng.xml file and select 'Run ...\testng.xml'


#Steps to review Allure report after running testng.xml:
1. Run Command Prompt
2. Type following command:
allure serve absolute_path_to_project_location
3. Press Enter and the report will be showing.


#Write new test script
1. Add a new Class under com.auto.openweather.ui.tests
2. Make sure that class extends BaseTest class. BaseTest class is used to initialize driver and close driver after execution.

#Write new test script with data driven
1. Create data file
2. Modify src/test/resources/DataMappings.csv
test_case_id    | data_type | data_file_path
----------------| ----------| ---------------
Test method name| XLSX      | Path of the data file of the test case.

3. Add Data Provider Class to @Test method as below
@Test(dataProvider = "testData", dataProviderClass = ExcelDataProvider.class)
public void TC01_SearchWeatherUsingCombinationOfCityNameAndCountryCode(String searchKeyword){
        ....
}



    

