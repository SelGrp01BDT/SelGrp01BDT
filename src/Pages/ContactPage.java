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
        // 1. Input Name, Category
    	driver.findElement(By.xpath(nameTextXpath)).clear();
    	driver.findElement(By.xpath(nameTextXpath)).sendKeys(name);

        // 2. Select Category
    	
    	if (!category.isEmpty())
    	{
    		WebElement comboBox = driver.findElement(By.xpath(categoryCbbXpath));
    		Select selectedValue = new Select(comboBox);
    		selectedValue.selectByVisibleText(category);
    	}
    	
    	// 2. Select Status
    	
    	if (!status.isEmpty())
    	{
    		WebElement comboBox = driver.findElement(By.xpath(statusCbbXpath));
    		Select selectedValue = new Select(comboBox);
    		selectedValue.selectByVisibleText(status);
    	}
    	
    	// 2. Click Save&Close button
    	driver.findElement(By.xpath(saveCloseBtnXpath)).click();
    	
    	 	
    	// 3. return ContactsPage PageObject
    	return new ContactsPage(driver);
    }
    
	private String nameTextXpath = ".//*[@id='jform_name']";
	private String categoryCbbXpath = ".//*[@id='jform_catid']";
	private String statusCbbXpath = ".//*[@id='jform_published']";
	private String saveCloseBtnXpath = ".//*[@id='toolbar-save']/a";
}
