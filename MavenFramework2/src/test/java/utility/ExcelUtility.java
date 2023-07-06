package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtility {
	
	static String path = "C:\\Users\\Lenovo\\Documents\\HRMData.xlsx";   // local machine 
	//static String path = System.getProperty("user.dir") + "\\src\\test\\java\\HRMData.xlsx";  // project workspace
	
	static DataFormatter formatter = new DataFormatter();  // class define by Apache poi //
	
	public static Object[][] getTestData(String sheetName) throws IOException {
		
		FileInputStream file = new FileInputStream(path);
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();  // no. of row
		XSSFRow row = sheet.getRow(0);
		int cellCount = row.getLastCellNum();   // no. of cell
		
		Object[][] data = new Object[rowCount][cellCount];
		for(int i=0;i<rowCount;i++) {    // here i=0 means first row
			row = sheet.getRow(i+1);        // first row (index=0) contains headings, so i+1 will take to next row
			for(int j=0;j<cellCount;j++) {  
                XSSFCell cell = row.getCell(j);   // cell/column
                data[i][j] = formatter.formatCellValue(cell);  // it will covert any type of data into string  
			}
		}
		return data;
	}
}

