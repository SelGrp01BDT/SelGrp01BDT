	package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.AbstractPage;

public class BannerManagerClients extends AbstractPage{

	private WebDriver driver;
	
	public BannerManagerClients(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createNewClient(String clientname, String contactname, String email, String status, String action) {
		//driver.findElement(btn_new).click();
		driver.findElement(txt_clientname).sendKeys(clientname);
		driver.findElement(txt_contactname).sendKeys(contactname);
		driver.findElement(txt_email).sendKeys(email);
		
		if (status != "none") {
			WebElement dropDownListBox = driver.findElement(By.xpath(".//*[@id='jform_state']"));
			Select clickItem = new Select(dropDownListBox);
			clickItem.selectByVisibleText(status);
		}
		
		switch(action) {
			case "saveandclose":
				driver.findElement(btn_save_close).click();
				break;
			case "save":
				driver.findElement(btn_save).click();
				break;
		}
		
	}
	
	public void editClient(String clientname, String contactname, String email, String status, String action) {
		driver.findElement(txt_clientname).clear();
		driver.findElement(txt_clientname).sendKeys(clientname);
		driver.findElement(txt_contactname).clear();
		driver.findElement(txt_contactname).sendKeys(contactname);
		driver.findElement(txt_email).clear();
		driver.findElement(txt_email).sendKeys(email);
		
		switch(action) {
			case "saveandclose":
				driver.findElement(btn_save_close).click();
				break;
			case "save":
				driver.findElement(btn_save).click();
				break;
		}
		
	}
	
	public void publishClient(String contactname) throws InterruptedException {
		WebElement dropDownListBox = driver.findElement(cbo_filter);
		Select clickItem = new Select(dropDownListBox);
		clickItem.selectByVisibleText("Unpublished");
		selectClientToEdit(contactname);
		clickToolbarButton("Publish");
	}
	
	public void selectClientToEdit(String clientname) throws InterruptedException {
		driver.findElement(By.xpath("//td[contains(text(),'" + clientname + "')]/preceding-sibling::td/input[@name= 'cid[]']")).click();		
	}
	
	public void clickToolbarButton(String button) {
		driver.findElement(By.linkText(button)).click();
	}
	
	public BM_EditClientPage selectClient(String clientname) {
		searchClient(clientname);
		driver.findElement(By.linkText(clientname)).click();
		return new BM_EditClientPage(driver);
	}
	
	public BM_NewClientPage goToAddClient(WebDriver driver) {
		driver.findElement(btn_new).click();
		return new BM_NewClientPage(driver);
	}
	
	public BM_EditClientPage goToEditClient(WebDriver driver) {
		driver.findElement(btn_edit).click();
		return new BM_EditClientPage(driver);
	}
	
	public void searchClient(String searchtext) {
		driver.findElement(btn_clear).click();
		driver.findElement(txt_search).sendKeys(searchtext);
		driver.findElement(btn_search).click();
	}
	
    public void selectStatus(String item) {
    	WebElement dropDownListBox = driver.findElement(cbo_filter);
		Select clickItem = new Select(dropDownListBox);
		clickItem.selectByVisibleText(item);
    }
	
	private By txt_clientname = By.xpath("//*[@id='jform_name']");
	private By txt_contactname = By.xpath("//*[@id='jform_contact']");
	private By txt_email = By.xpath("//*[@id='jform_email']");
	private By btn_new = By.xpath("//*[@id='toolbar-new']/a/span");
	private By btn_save_close = By.xpath("//*[@id='toolbar-save']/a/span");
	private By btn_edit = By.xpath("//*[@id='toolbar-edit']/a/span");
	private By btn_save = By.xpath("//*[@id='toolbar-apply']/a/span");
	private By cbo_filter = By.xpath(".//*[@id='filter-bar']/div[2]/select");
	private By txt_search = By.xpath(".//*[@id='filter_search']");
	private By btn_search = By.xpath(".//button[text()='Search']");
	private By btn_clear = By.xpath(".//button[text()='Clear']");
}
