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

public class TC_JOOMLA_BANNERS_CLIENTS_002 extends AbstractTest {

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
		AdministratorPage adminpage = login.Do(Config.username_home, Config.password_home);
		
		// Banner Manager page
		BannerManagerClients bannermanager = adminpage.openBannerClients();
		
		// Banner Manager: Add New Client
		BM_NewClientPage bmAddNew = bannermanager.goToAddClient(driver);
		
		// Banner Manager: Edit Client page
		BM_EditClientPage bmEditClient = bmAddNew.createNewClient(clientname1, contactname, email, "none", "save");
		verifyTextPresent(driver, "Client successfully saved");
		
		// Return Banner Manager page
		bannermanager = bmEditClient.editClient(clientname2, contactname, email, "none", "saveandclose");		
		
		// VP: _ A message : "Client successfully saved" shows.
		verifyTextPresent(driver, "Client successfully saved");
		//VP: _ Client is edited
		bmEditClient = bannermanager.selectClient(clientname2);
		bmEditClient.verifyInformationOfClientDisplayCorrectly(clientname2, contactname, email);
		
	}	

	private String clientname1 = getUniqueString("baton");
	private String clientname2 = getUniqueString("baton1211");
	private String contactname = "baton";
	private String email = "baton@lg.com";
}
