package pack;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static List<Object[]> readExcelData(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);
        int numberOfRows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < numberOfRows; i++) {
            Row row = sheet.getRow(i);
            int numberOfCells = row.getPhysicalNumberOfCells();
            Object[] rowData = new Object[numberOfCells];

            for (int j = 0; j < numberOfCells; j++) {
                Cell cell = row.getCell(j);
                switch (cell.getCellType()) {
                    case STRING:
                        rowData[j] = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        rowData[j] = cell.getNumericCellValue();
                        break;
                    case BOOLEAN:
                        rowData[j] = cell.getBooleanCellValue();
                        break;
                    default:
                        rowData[j] = null;
                }
            }
            data.add(rowData);
        }
        workbook.close();
        fis.close();
        return data;
    }
}

