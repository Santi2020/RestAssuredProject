package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) throws IOException {
	
		workBook = new XSSFWorkbook(excelPath);
		sheet = workBook.getSheet(sheetName);
	}
	public static void main_temp(String[] args) throws IOException {
		
		String projDir= System.getProperty("user.dir");
		System.out.println(projDir);
		String excelPath = projDir+"//data/testdata.xlsx";
		System.out.println(excelPath);
		
		ExcelUtils xlUtils = new ExcelUtils( excelPath, "Sheet1");
		//getRowCount();
		//getCellData();
	}
	
	public static void getRowCount() throws IOException {
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("rowCount = " + rowCount);		
	}
	
	public static void getCellData(int rowNum, int colNum) {
		DataFormatter formatter = new DataFormatter();
		Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		System.out.println("Cell value = " + value);
	}
}
