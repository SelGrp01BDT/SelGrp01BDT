package TestCases.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Common.Config;
import Pages.AdministratorPage;
import Pages.LoginPage;

public class DanDemo {
	
	@Test
	public static void VerifyLogin() {
		Config config = new Config();
		String urlstr = config.url;
		Config.OpenSite(urlstr);
		;

		WebDriver driver = new FirefoxDriver();
		// instantiate LoginPage
		LoginPage loginpage = new LoginPage(driver);

		// Login.Do returns the AdministratorPage PageObject
		AdministratorPage adminpage = loginpage.Do("Selenium_Team1", "123456");

		// Administrator.Logout returns LoginPage
		if (adminpage != null) {
			loginpage = adminpage.Logout();
		}
		
		driver.quit();
	}

	
	
}
