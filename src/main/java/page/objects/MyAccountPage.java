package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="username")
	public WebElement usernameField;
	
	@FindBy(id="password")
	public WebElement passwordField;
	
	@FindBy(css="button[name='login']")
	public WebElement loginBtn;
	
	public void loginInApp (String username, String password) {
		
		sendKeys(usernameField, username);
		sendKeys(passwordField, password);
		click(loginBtn);
		
	}
	
	
	}


