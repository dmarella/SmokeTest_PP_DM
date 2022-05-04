package E2ETest.testdata;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author Purna 
 * This is ExcelData Reader class
 */
//
public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet updatepersonalinfo;

	public ExcelDataConfig(String excelPath) {
		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

public final String getData(int sheetNumber, int row, int column) {
DataFormatter formatter = new DataFormatter();
updatepersonalinfo = wb.getSheetAt(sheetNumber);
String data1 =
formatter.formatCellValue(updatepersonalinfo.getRow(row).getCell(column));
return data1;
	}

}
