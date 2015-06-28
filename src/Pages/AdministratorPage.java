package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    
    // Go to Banner Clients page
    public BannerManagerClients openBannerClients()
    {
    	driver.findElement(ComponentsmenuXpath).click();
    	Actions actions = new Actions(driver);
    	WebElement mainMenu = driver.findElement(BannerXpath);
    	actions.moveToElement(mainMenu).perform();
    	driver.findElement(BannerClientsXpath).click();
    	
    	return new BannerManagerClients(driver);
    }

    private By ComponentsmenuXpath = By.xpath(".//*[@id='menu']/li[5]/a");
    private By BannerXpath = (By.xpath(".//*[@id='menu']/li[5]/ul/li[1]/a"));
    private By BannerClientsXpath = By.xpath(".//*[@id='menu-com-banners']/li[3]/a");
    private String ComponentsXpath = ".//*[@id='menu']/li[5]/a";
    private String ContactsXpath = ".//*[@id='menu']/li[5]/ul/li[2]/a";
    
}
