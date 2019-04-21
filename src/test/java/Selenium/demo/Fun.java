package Selenium.demo;
import java.io.*;
import java.util.Properties;
import java.net.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class Fun {
	@Test
	public  void done()throws IOException
	{
		System.out.println("Hello World");
	}
	
	
	public static void main(String args[])throws IOException
	{
		FileInputStream reader=new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/java/Selenium/resources/db.properties"));
		Properties p=new Properties();
		p.load(reader);
		System.out.println(p.getProperty("appUrl"));
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.108:4444/wd/hub"),options);
		driver.get("https://www.facebook.com");
		
	}
}
