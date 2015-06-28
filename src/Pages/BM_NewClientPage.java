package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.AbstractPage;

public class BM_NewClientPage extends AbstractPage  {

	private WebDriver driver;
	
	public BM_NewClientPage(WebDriver driver)
	{ 
	    this.driver = driver;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T createNewClient(String clientname, String contactname, String email, String status, String action) {
		driver.findElement(txt_clientname).sendKeys(clientname);
		driver.findElement(txt_contactname).sendKeys(contactname);
		driver.findElement(txt_email).sendKeys(email);
		
		if (status != "none") {
			//selectdropDownListItem(cbo_status ,status);
			WebElement dropDownListBox = driver.findElement(cbo_status);
			Select clickItem = new Select(dropDownListBox);
			clickItem.selectByVisibleText(status);
		}
		
		switch(action) {
			case "saveandclose":
				driver.findElement(btn_save_close).click();
				return (T) new BannerManagerClients(driver);
		case "save":
				driver.findElement(btn_save).click();
				return (T) new BM_EditClientPage(driver);
		}
		return null;
	}
	
	private By txt_clientname = By.xpath("//*[@id='jform_name']");
	private By txt_contactname = By.xpath("//*[@id='jform_contact']");
	private By txt_email = By.xpath("//*[@id='jform_email']");
	private By btn_save_close = By.xpath("//*[@id='toolbar-save']/a/span");
	private By btn_save = By.xpath("//*[@id='toolbar-apply']/a/span");
	private By cbo_status = By.xpath(".//*[@id='jform_state']");
}
