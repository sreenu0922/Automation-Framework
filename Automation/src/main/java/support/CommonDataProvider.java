package support;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class CommonDataProvider  {

    public static ExcelReader excel = new ExcelReader();

    @BeforeClass
    public void executeExcelSheetRunTime() {
        excel = new ExcelReader();
    }

    @DataProvider(name = "commonTestData")
    public static Object[][] getData(String sheetName) {

        int rows = excel.getRowCount(sheetName);
        int cols = excel.getColumnCount(sheetName);

        Object[][] data = new Object[rows - 1][1];

        Hashtable<String, String> table = null;

        for (int rowNum = 1; rowNum < rows; rowNum++) {

            table = new Hashtable<String, String>();

            for (int colNum = 0; colNum < cols; colNum++) {

                table.put(excel.getCellData(sheetName, 0, colNum), excel.getCellData(sheetName, rowNum, colNum));

            }
            data[rowNum - 1][0] = table;
        }
        return data;
    }
}
