package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactsPage {
	private WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public ContactPage OpenContactPage()
    {
        // 1. click New icon
    	driver.findElement(By.xpath(newIconXpath)).click();
    	
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
    
	// public ContactPage selectContactToEdit(String contactname) throws InterruptedException {
		
	//	driver.findElement(By.xpath("//table/tbody/tr/td/a[contains(text(),'" + contactname + "')]")).click();		
	//	return new ContactPage(driver);

	//}
	
	//public void searchContact(String searchtext)
	//{
	//	WebElement txtbox = driver.findElement(By.xpath(filterTxtboxXpath));
	//	txtbox.click();
	//	txtbox.clear();
	//	txtbox.sendKeys(searchtext);
	//	driver.findElement(By.xpath(filterbuttonXpath)).click();
		
	//}
	
	 public ContactPage OpenEditContactPage()
	    {
	        // 1. click New icon
	    	driver.findElement(By.xpath(firstRowLinkXpath)).click();
	    	
	    	// 2. return ContactPage PageObject
	    	return new ContactPage(driver);
	    }
	
	private String newIconXpath = ".//*[@id='toolbar-new']/a/span";
	private String firstRowLinkXpath = ".//*[@id='adminForm']/table/tbody/tr[1]/td[2]/a";

	///private String NotificationLblXpath = ".//*[@id='system-message']/dd/ul/li";
}
