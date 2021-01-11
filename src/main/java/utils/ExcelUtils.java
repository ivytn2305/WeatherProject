package utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(filePath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;

    }

    public int getColCount() {
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return colCount;

    }


    public Object getCellData(int rowNum, int colNum) {
        DataFormatter dataFormatter = new DataFormatter();
        Object cellValue = dataFormatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        return cellValue;
    }
}
