package TestCases.BannerClients;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.AbstractTest;
import Common.BrowserExecution;
import Common.Config;
import Pages.AdministratorPage;
import Pages.BannerManagerClients;
import Pages.LoginPage;

public class TC_JOOMLA_BANNERS_CLIENTS_001 extends AbstractTest {
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new FirefoxDriver();
		BrowserExecution.navigateJoomla(driver);
	}

	@AfterTest
	public void tearDown() {
		BrowserExecution.closeJoomla();
	}

	@Test
	public void verify_create_new_client() throws Exception {

		LoginPage login = new LoginPage(driver);
		AdministratorPage adminpage = login.Do(Config.username_home,
				Config.password_home);
		BannerManagerClients bannermanager = adminpage.openBannerClients();
		bannermanager.createNewClient("baton", "baton", "baton1211@gmail.com", "none", "saveandclose");

		verifyTextPresent(driver, "Client successfully saved");

	}

}
