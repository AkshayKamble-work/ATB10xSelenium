package DataDriven;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadUtility {
static Workbook book;
static Sheet sheet;

    public static String filePath = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";

    public static  Object[][]getTestData(String sheetname)
    {
        FileInputStream fis= null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            book=WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sheet=book.getSheet(sheetname);

        Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        {
            for (int i = 0; i <sheet.getLastRowNum() ; i++)
            {

                for (int j = 0; j <sheet.getRow(0).getLastCellNum() ; j++)
                {
                    // First row email, password -> coumn name - skip - header
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }
        }
        return data;
    }

}
