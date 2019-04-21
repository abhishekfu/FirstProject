package Selenium.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datapro {
	
	@Test(dataProvider="GetData")
	public void readData(String username,String password) throws IOException {
		
		System.out.println(username + " "+password);
		
	}
	
	@DataProvider(name="GetData")
	public Object[][] getData() throws IOException{
		FileInputStream fis =new FileInputStream(new File(System.getProperty("user.dir")+"//src//test//java//Selenium//resources//testData.xlsx"));
		Workbook wb=new XSSFWorkbook(fis);
		Sheet sh=wb.getSheetAt(0);
		Object[][] ob=new Object[sh.getLastRowNum()+1][2];
		for(int i=0;i<=sh.getLastRowNum();i++) {
			Row row=sh.getRow(i);
			ob[i][0]=row.getCell(0).getStringCellValue();
			ob[i][1]=row.getCell(1).getStringCellValue();
			
		}
		return ob;
	}
}
