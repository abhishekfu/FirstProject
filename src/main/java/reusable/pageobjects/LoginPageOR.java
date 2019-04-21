package reusable.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageOR {
	/*public static By mailid=By.id("email");
	public static By pswd=By.name("pass");
	public static By loginBtn=By.linkText("Log In");*/
	
	@FindBy(how=How.ID,using="email")
	@CacheLookup
	public static WebElement mailid;
	
	@FindBy(how=How.NAME,using="pass")
	@CacheLookup
	public static WebElement passwd;
	
	@FindBy(how=How.LINK_TEXT,using="Log In")
	@CacheLookup
	public static WebElement loginBtn;
}
