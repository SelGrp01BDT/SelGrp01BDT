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
		driver.findElement(btn_new).click();
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
	
	public void selectClientToEdit(String clientname) throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(),'" + clientname + "')]/preceding::td/input[@name='cid[]']")).click();;		
	}
	
	public void clickToolbarButton(String button) {
		driver.findElement(By.linkText(button)).click();
	}
	
	private By txt_clientname = By.xpath("//*[@id='jform_name']");
	private By txt_contactname = By.xpath("//*[@id='jform_contact']");
	private By txt_email = By.xpath("//*[@id='jform_email']");
	private By btn_new = By.xpath("//*[@id='toolbar-new']/a/span");
	private By btn_save_close = By.xpath("//*[@id='toolbar-save']/a/span");
	private By btn_edit = By.xpath("//*[@id='toolbar-edit']/a/span");
	private By btn_save = By.xpath("//*[@id='toolbar-apply']/a/span");
	private By btn_delete = By.xpath(".//*[@id='toolbar-trash']/a/span");

}
