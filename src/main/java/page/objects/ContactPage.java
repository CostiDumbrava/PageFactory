package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import selenium.utils.SeleniumWrappers;

public class ContactPage extends SeleniumWrappers{
	
	public ContactPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="your-name")
	public WebElement nameField;
	
	@FindBy(name="your-email")
	public WebElement emailField;
	
	@FindBy(name="your-subject")
	public WebElement subjectField;
	
	@FindBy(name="your-message")
	public WebElement messageField;
	
	@FindBy(xpath="//input[@value='Send Message']")
	public WebElement submitBtn;
	
	@FindBy(css= "div[class='wpcf7-response-output']")
	public WebElement sendMsgText;
	

	public void sendMessage(String name, String email, String subject, String message) {  //daca se ajunge la 5-6 parametri insemna ca metoda ar trebui optimizata, nu putem adauga foarte multi parametri
		
	     sendKeys(nameField, name);
	     sendKeys(emailField, email);
	     sendKeys(subjectField, subject);
	     sendKeys(messageField,message);
	     click(submitBtn);
	     
		}
}
