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
    
    public ContactsPage CreateNewContact(String name, String category)
    {
        // 1. Input Name, Category
    	driver.findElement(By.xpath(NameTextXpath)).sendKeys(name);
    	//Select select = new Select(driver.findElement(By.xpath(CategoryCbbXpath)));
    	//select.deselectAll();
    	//select.selectByVisibleText(category);
    	
    	WebElement comboBox = driver.findElement(By.xpath(CategoryCbbXpath));
    	Select selectedValue = new Select(comboBox);
    	selectedValue.selectByVisibleText(category);
   
    	// 2. Click Save&Close button
    	driver.findElement(By.xpath(SaveCloseBtnXpath)).click();
    	
    	 	
    	// 3. return ContactsPage PageObject
    	return new ContactsPage(driver);
    }
    
	private String NameTextXpath = ".//*[@id='jform_name']";
	private String CategoryCbbXpath = ".//*[@id='jform_catid']";
	private String SaveCloseBtnXpath = ".//*[@id='toolbar-save']/a";
}
