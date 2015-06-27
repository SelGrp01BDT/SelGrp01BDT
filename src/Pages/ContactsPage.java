package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ContactsPage {
	private WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public ContactPage OpenContactPage()
    {
        // 1. click New icon
    	driver.findElement(By.xpath(NewIconXpath)).click();
    	
    	// 2. return ContactPage PageObject
    	return new ContactPage(driver);
    }
    
	public boolean IsTextPresent(String textToBeVerified)
	{
	try
	      {
	      if (driver.findElement(By.xpath("//*[contains(.,'" + textToBeVerified + "')]")) != null)   
	    	  return true;
	      else 
	    	  return false;

	} 
	catch (Exception ex)
	{
	return false;
	}	
	}
    
    
	private String NewIconXpath = ".//*[@id='toolbar-new']/a/span";
	///private String NotificationLblXpath = ".//*[@id='system-message']/dd/ul/li";
}
