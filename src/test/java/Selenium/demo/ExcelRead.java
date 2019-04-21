package Selenium.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	@Test
	public void readData() throws IOException {
		int i;
		
		FileInputStream fis =new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//java//Selenium//resources//testData.xlsx"));
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sh=wb.getSheetAt(0);
		for(i=0;i<=sh.getLastRowNum();i++) {
			Row row=sh.getRow(i);
			System.out.println(row.getCell(0).getStringCellValue()+row.getCell(1).getStringCellValue());
		}
		Sheet sh1=wb.createSheet();
		for(i=0;i<5;i++) {
			Row row1=sh1.createRow(i);
			row1.createCell(0).setCellValue("Abhishek");
			row1.createCell(1).setCellValue("Jha");
		}
		FileOutputStream fos=new FileOutputStream(new File(System.getProperty("user.dir")+"//src//test//java//Selenium//resources//testData.xlsx"));
		wb.write(fos);
		fos.close();
		fos.flush();
	}
}
