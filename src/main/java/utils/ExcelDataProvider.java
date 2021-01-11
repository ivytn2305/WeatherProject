package utils;

import common.BasePage;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class ExcelDataProvider {

    @DataProvider(name = "testData")
    public Object[][] getData(Method m) throws IOException {
        String excelPath = "";
        Object dataMappings[][] = testData(BasePage.getDataMappingFilePath(), BasePage.sheetName);

        for (int i = 0; i < dataMappings.length; i++) {
            if (dataMappings[i][0].toString().equalsIgnoreCase(m.getName())) {
                int indexOfDataFileColumn = dataMappings[i].length - 1;
                excelPath = BasePage.getTestDataInitialPath() + dataMappings[i][indexOfDataFileColumn].toString();
                System.out.println(excelPath);
            }
        }
        Object data[][] = testData(excelPath, BasePage.sheetName);
        return data;
    }

    public Object[][] testData(String excelPath, String sheetName) {
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        int rowCount = excelUtils.getRowCount();
        int colCount = excelUtils.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                Object cellData = excelUtils.getCellData(i, j);
                data[i - 1][j] = cellData;
            }
        }
        return data;
    }


}
