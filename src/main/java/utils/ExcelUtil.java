package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static List<Object[]> getTestData(String excelFilePath, String sheetName) {
        List<Object[]> data = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < rowCount; i++) { // Skipping the header row
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String executionRequired = row.getCell(2).getStringCellValue(); // Assuming "Execution Required" is in the 3rd column (index 2)

                if ("Yes".equalsIgnoreCase(executionRequired)) {
                    int cellCount = row.getPhysicalNumberOfCells();
                    String[] rowData = new String[cellCount];
                    for (int j = 0; j < cellCount; j++) {
                        XSSFCell cell = (XSSFCell) row.getCell(j);
                        if (cell == null) {
                            rowData[j] = "";
                        } else {
                            cell.setCellType(CellType.STRING);
                            rowData[j] = cell.getStringCellValue();
                        }
                    }
                    data.add(rowData);
                }
            }
            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        List<Object[]> testData = getTestData("TestingData.xlsx", "Sheet1");
        for (Object[] data : testData) {
            for (Object value : data) {
                System.out.print("||" + value);
            }
            System.out.println();
        }
    }
}
