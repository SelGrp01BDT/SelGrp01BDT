package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	private WebDriver driver;
	
	public ContactPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public ContactsPage CreateNewContact(String name, String category, String status)
    {
        // 1. Input Name, 
    	driver.findElement(By.xpath(NameTextXpath)).sendKeys(name);
    	//Select select = new Select(driver.findElement(By.xpath(CategoryCbbXpath)));
    	//select.deselectAll();
    	//select.selectByVisibleText(category);
    	
    	// 2. Select Category
    	
    	if (category.isEmpty())
    	{
    	WebElement categoryccb = driver.findElement(By.xpath(CategoryCbbXpath));
    	Select selectedcategory = new Select(categoryccb);
    	selectedcategory.selectByVisibleText(category);
    	}
   
    	// 3. Select Status
    	
    	if (status.isEmpty())
    	{
    	WebElement statusccb = driver.findElement(By.xpath(StatusCbbXpath));
    	Select selectedstatus = new Select(statusccb);
    	selectedstatus.selectByVisibleText(status);
    	}
    	
    	// 4. Click Save&Close button
    	driver.findElement(By.xpath(SaveCloseBtnXpath)).click();
    	
    	 	
    	// 5. return ContactsPage PageObject
    	return new ContactsPage(driver);
    }
    
	private String NameTextXpath = ".//*[@id='jform_name']";
	private String CategoryCbbXpath = ".//*[@id='jform_catid']";
	private String SaveCloseBtnXpath = ".//*[@id='toolbar-save']/a";
	private String StatusCbbXpath = ".//*[@id='jform_published']";
}
