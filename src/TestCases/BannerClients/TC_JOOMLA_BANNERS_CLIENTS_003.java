package TestCases.BannerClients;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.AbstractTest;
import Common.Config;
import Pages.AdministratorPage;
import Pages.BM_NewClientPage;
import Pages.BannerManagerClients;
import Pages.LoginPage;

public class TC_JOOMLA_BANNERS_CLIENTS_003 extends AbstractTest {

	@BeforeTest
	public void setUp() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(Config.url_home);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
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

		// Return Banner Manager page
		bannermanager = bmAddNew.createNewClient(clientname, contactname, email, "Unpublished", "saveandclose");
		verifyTextPresent(driver, "Client successfully saved");
		
		bannermanager.publishClient(contactname);
		verifyTextPresent(driver, "1 client successfully published");
	}
	
	private String clientname = getUniqueString("baton");
	private String contactname = getUniqueString("ct");
	private String email = "baton@lg.com";
}
