package Selenium.demo;








import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.DataProvider;
import org.apache.commons.io.FileUtils;
import reusable.pageobjects.LoginPageOR;

public class FacebookTest extends LoginPageOR {

	ExtentTest test;
	ExtentReports report;
	
	@Test(dataProvider="dp")
	public void Login(String username,String pswd) throws InterruptedException, IOException {
		
		report=new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
		test.log(LogStatus.PASS, "abc");
		test.log(LogStatus.FAIL, "def");
		test.log(LogStatus.INFO, "ghi");
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/driver/geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.facebook.com");
		Thread.sleep(5000);
		System.out.println("Hello");
		PageFactory.initElements(driver, LoginPageOR.class);
		try {
		
		mailid.sendKeys(username);
		Thread.sleep(5000);
		passwd.sendKeys(pswd);
		Thread.sleep(5000);
		loginBtn.click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path=System.getProperty("user.dir") + "/driver/"+dateName+".png";
			File finalDestination = new File(path);
			FileUtils.copyFile(source, finalDestination);
			test.log(LogStatus.PASS, test.addScreenCapture(path));
			report.endTest(test);
			report.flush();
			report.close();
			
			
		driver.quit();
		}
	}
	
	@DataProvider
	public Object[][] dp(){
		return new Object[][]{
		new Object[] {"abhishekjha201163@gmail.com","abcd"},
		new Object[] {"abhishekjha201163@gmail.com","daynavendetta"},
	};
}
}
