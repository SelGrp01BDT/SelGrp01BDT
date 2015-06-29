package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BM_EditClientPage {

private WebDriver driver;
	
	public BM_EditClientPage(WebDriver driver)
	{ 
	    this.driver = driver;
	}
	
	public BannerManagerClients editClient(String clientname, String contactname, String email, String status, String action) {
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
		
		return new BannerManagerClients(driver);
	}
	
	public void verifyInformationOfClientDisplayCorrectly(String clientname, String contactname, String email) {
		String clname = driver.findElement(txt_clientname).getText();
		clname.equals(clientname);
		String ctname = driver.findElement(txt_contactname).getText();
		ctname.equals(contactname);
	}
	
	public void verifyClientStatus(String status) {
		
		String clientstatus = driver.findElement(cbo_status).getText();
		clientstatus.equals(status);
	}

	private By txt_clientname = By.xpath("//*[@id='jform_name']");
	private By txt_contactname = By.xpath("//*[@id='jform_contact']");
	private By txt_email = By.xpath("//*[@id='jform_email']");
	private By btn_save_close = By.xpath("//*[@id='toolbar-save']/a/span");
	private By btn_save = By.xpath("//*[@id='toolbar-apply']/a/span");
	private By cbo_status = By.xpath(".//*[@id='jform_state']");
}
