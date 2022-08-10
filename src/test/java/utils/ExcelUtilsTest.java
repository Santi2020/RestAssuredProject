package utils;

import java.io.IOException;

public class ExcelUtilsTest {

	public static void main(String[] args) throws IOException {
		String projDir= System.getProperty("user.dir");
		System.out.println(projDir);
		String excelPath = projDir+"//data/testdata.xlsx";
		System.out.println(excelPath);
		
		ExcelUtils excel = new ExcelUtils( excelPath, "Sheet1");
		excel.getRowCount();
		
		excel.getCellData(1,0);
		excel.getCellData(1,1);
		excel.getCellData(1,2);
		
	}
}
