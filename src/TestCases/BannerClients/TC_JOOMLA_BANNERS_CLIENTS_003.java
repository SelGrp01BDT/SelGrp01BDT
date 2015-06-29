package TestCases.BannerClients;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.AbstractTest;
import Common.BrowserExecution;
import Common.Config;
import Pages.AdministratorPage;
import Pages.BM_EditClientPage;
import Pages.BM_NewClientPage;
import Pages.BannerManagerClients;
import Pages.LoginPage;

public class TC_JOOMLA_BANNERS_CLIENTS_003 extends AbstractTest {

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
	public void verify_create_client() throws Exception {
		
		// Administrator page
		LoginPage login = new LoginPage(driver);
		AdministratorPage adminpage = login.Do(Config.username_home,
				Config.password_home);
		
		// Banner Manager page
		BannerManagerClients bannermanager = adminpage.openBannerClients();
		
		// Banner Manager: Add New Client
		BM_NewClientPage bmAddNew = bannermanager.goToAddClient(driver);
		bannermanager = bmAddNew.createNewClient(clientname, contactname, email, "Unpublished", "saveandclose");

		// VP: _ A message : "Client successfully saved" shows.
		verifyTextPresent(driver, "Client successfully saved");
		
		// VP: _ A message : "1 client successfully published" shows.
		bannermanager.publishClient(contactname);
		verifyTextPresent(driver, "1 client successfully published");

		// VP: _ Client is published
		bannermanager.selectStatus("All");
		BM_EditClientPage bmEditClient = bannermanager.selectClient(clientname);
		bmEditClient.verifyClientStatus("Publish");
	}
	
	private String clientname = getUniqueString("baton");
	private String contactname = getUniqueString("ct");
	private String email = "baton@lg.com";
}
