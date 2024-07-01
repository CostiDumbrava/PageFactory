package tests;

import org.testng.annotations.Test;

import framework.utils.PropertiesFileProcessor;
import page.objects.MenuPage;
import page.objects.MyAccountPage;
import selenium.utils.BaseTest;

public class LoginTest extends BaseTest{
	

	String USER = PropertiesFileProcessor.readPropertiesFile("user","credentials.properties");
	String 	PASS = PropertiesFileProcessor.readPropertiesFile("pass","credentials.properties");
	
	@Test
	public void validLogin() {
		
		MenuPage menu = new MenuPage(driver);
		MyAccountPage myAccount = new MyAccountPage(driver);
		
		menu.click(menu.myAccountLink);
		myAccount.loginInApp(USER, PASS);
		
	}

}
