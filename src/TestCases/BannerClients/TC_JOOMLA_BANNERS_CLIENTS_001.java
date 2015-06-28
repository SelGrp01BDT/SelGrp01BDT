package TestCases.BannerClients;

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
		BrowserExecution.closeJoomla(driver);
	}

	@Test
	public void verify_create_new_client() throws Exception {

		LoginPage login = new LoginPage(driver);
		AdministratorPage adminpage = login.Do(Config.username_home,
				Config.password_home);
		BannerManagerClients bannermanager = adminpage.openBannerClients();
		bannermanager.createNewClient(username, contactname, email, "none", "saveandclose");
		verifyTextPresent(driver, "Client successfully saved");
	}

	private String username = getUniqueString("baton");
	private String contactname = "baton";
	private String email = "baton@lg.com";
}
