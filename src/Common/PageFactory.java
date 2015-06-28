package Common;

import org.openqa.selenium.WebDriver;

import Pages.AdministratorPage;

public class PageFactory {

	public static AdministratorPage getAdministratorPage(WebDriver driver) {
		return new AdministratorPage(driver);
	}
	
}
