package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;

import Common.AbstractPage;

public class BannerManagerClients extends AbstractPage{

	private WebDriver driver;
	
	public BannerManagerClients(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createNewClient(String clientname, String contactname, String email) {
		driver.findElement(btn_new).click();
		driver.findElement(txt_clientname).sendKeys(clientname);
		driver.findElement(txt_contactname).sendKeys(contactname);
		driver.findElement(txt_email).sendKeys(email);
		driver.findElement(btn_save_close).click();
	}
	
	public void clickToolbarButton(String button) {
		driver.findElement(By.linkText(button)).click();
	}
	
	private By txt_clientname = By.xpath("//*[@id='jform_name']");
	private By txt_contactname = By.xpath("//*[@id='jform_contact']");
	private By txt_email = By.xpath("//*[@id='jform_email']");
	private By btn_new = By.xpath("//*[@id='toolbar-new']/a/span");
	private By btn_save_close = By.xpath("//*[@id='toolbar-save']/a/span");

}
