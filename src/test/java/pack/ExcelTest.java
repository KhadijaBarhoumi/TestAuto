package pack;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ExcelTest {

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() throws IOException {
        String filePath = "src/test/resources/testdata.xlsx";
        List<Object[]> data = ExcelReader.readExcelData(filePath);
        return data.toArray(new Object[0][]);
    }

    @Test(dataProvider = "excelData")
    public void testWithExcelData(String col1, String col2, double col3) {
        // Votre code de test ici
        System.out.println("Col1: " + col1 + ", Col2: " + col2 + ", Col3: " + col3);
    }
}

