package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdministratorPage {

	private WebDriver driver;
	
	public AdministratorPage(WebDriver driver)
    { 
        this.driver = driver;
 
    }
	
	// returns LoginPage PageObject
    public LoginPage Logout()
    {
        // 1. log-off and return to LoginPage
        driver.findElement(By.linkText("Log out")).click();
 
        // 2. return the LoginPage object
        return new LoginPage(driver);
    }
    
    // Open Contacts menu
    public ContactsPage OpenContactsPage()
    {
        // 1. click Components / Contacts
    	driver.findElement(By.xpath(ComponentsXpath)).click();
    	driver.findElement(By.xpath(ContactsXpath)).click();
    	
    	// 2. return ContactsPage PageObject
    	return new ContactsPage(driver);
    }
    
  //return ArticlePage
    public ArticlePage NavigateArticle()
    {
    	//1. hover over Content link menu
    	driver.findElement(By.linkText("Content")).click();
    	
    	//2. click on Article Manager sub menu
    	driver.findElement(By.linkText("Article Manager")).click();
    	
    	//3. return ArticlePage PageObject
    	return new ArticlePage(driver);
    
    }
	
    private String try1;
    private String ComponentsXpath = ".//*[@id='menu']/li[5]/a";
    private String ContactsXpath = ".//*[@id='menu']/li[5]/ul/li[2]/a";
    
}
