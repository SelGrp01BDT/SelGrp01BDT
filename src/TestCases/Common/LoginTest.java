package TestCases.Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Common.Config;
import Pages.AdministratorPage;
import Pages.LoginPage;

public class LoginTest {

	@Test
	public static void VerifyLogin() {
		// instantiate FirefoxDriver and navigate to Joomla
		WebDriver driver = new FirefoxDriver();

		// navigate to joomla
		driver.navigate().to(Config.url_home);
		;

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
