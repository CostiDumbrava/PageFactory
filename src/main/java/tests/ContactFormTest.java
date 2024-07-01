package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import page.objects.ContactPage;
import page.objects.MenuPage;
import selenium.utils.BaseTest;

public class ContactFormTest extends BaseTest{
	
	@Test(priority=1)
	public void sendValidMessage() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.contactPageLink);
		
		ContactPage contactPage = new ContactPage(driver);
		contactPage.sendMessage("Ion","ion@ion.com", "Salut!", "Eu sunt Ion");	
		
		//1
		
		assertEquals(contactPage.getElementText(contactPage.sendMsgText),"Thank you for your message. It has been sent.");
		
		//2
		assertEquals(contactPage.sendMsgText.getText(),"Thank you for your message. It has been sent.");
		
	}
	
	@Test(priority=2)
	public void sendInvalidMessage() {
		
		MenuPage menuPage = new MenuPage(driver);
		menuPage.click(menuPage.contactPageLink);
		
		ContactPage contactPage = new ContactPage(driver);
		contactPage.sendMessage("Ion","", "Salut!", "Eu sunt Ion");	
		
		//1
		
		assertEquals(contactPage.getElementText(contactPage.sendMsgText),"Thank you for your message. It has been sent.");
		
		//2
		assertEquals(contactPage.sendMsgText.getText(),"Thank you for your message. It has been sent.");
		
	}

}
