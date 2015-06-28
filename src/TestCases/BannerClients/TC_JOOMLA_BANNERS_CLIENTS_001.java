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

		// Administrator page
		LoginPage login = new LoginPage(driver);
		AdministratorPage adminpage = login.Do(Config.username_home, Config.password_home);
		
		// Banner Manager page
		BannerManagerClients bannermanager = adminpage.openBannerClients();
		
		// Banner Manager: Add New
		BM_NewClientPage bmAddNew = bannermanager.goToAddClient(driver); 
		
		// Return Banner Manager page
		bannermanager = bmAddNew.createNewClient(clientname, contactname, email, "none", "saveandclose");
		
		// VP: _ A message : "Client successfully saved" shows.
		verifyTextPresent(driver, "Client successfully saved");
		// VP: _ New client is created and matched with entered data
		BM_EditClientPage bmEditClient = bannermanager.selectClient(clientname);
		bmEditClient.verifyInformationOfClientDisplayCorrectly(clientname, contactname, email);
	}

	private String clientname = getUniqueString("baton");
	private String contactname = "baton";
	private String email = "baton@lg.com";
}
