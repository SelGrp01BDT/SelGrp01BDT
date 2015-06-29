package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Common.AbstractPage;
import Common.AbstractTest;


public class ContactsPage extends AbstractPage{
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
	
	
	 public ContactPage OpenEditContactPage(String contactname)
	    {
	        
			searchItem(driver, filterTxtboxXpath, filterbuttonXpath,contactname);
		    driver.findElement(By.xpath(firstRowLinkXpath)).click();
	    	return new ContactPage(driver);
	    }
	
	public void publishContact(String contactname)
	{
		searchItem(driver, filterTxtboxXpath, filterbuttonXpath, contactname);
		publishItem(driver, publishIconXpath);
	}
	 
	 
	private String newIconXpath = ".//*[@id='toolbar-new']/a/span";
	private String firstRowLinkXpath = ".//*[@id='adminForm']/table/tbody/tr[1]/td[2]/a";
	private String filterTxtboxXpath = ".//*[@id='filter_search']";
	private String filterbuttonXpath = ".//*[@id='filter-bar']/div[1]/button[1]";
	private String publishIconXpath = ".//*[@id='toolbar-publish']/a/span";
	///private String NotificationLblXpath = ".//*[@id='system-message']/dd/ul/li";
}
