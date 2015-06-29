package TestCases.Contacts;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import Common.AbstractTest;
import Common.BrowserExecution;
import Common.Config;
import Pages.AdministratorPage;
import Pages.LoginPage;
import Pages.ContactsPage;
import Pages.ContactPage;

public class TC_JOOMLA_CONTACTS_001 extends AbstractTest {
	
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
	public void verify_create_new_contact() throws Exception {

		// Administrator page
		LoginPage login = new LoginPage(driver);
		AdministratorPage adminpage = login.Do(Config.username_home, Config.password_home);
		
		// Open Contacts Page
		ContactsPage contactspage = adminpage.OpenContactsPage();
					
		// Open Create Contact page
		ContactPage contactpage = contactspage.OpenContactPage();
					
		// Input Name, Category the click Save&Close button
		contactspage= contactpage.CreateNewContact(contactname, category,status);
					
		// verify create contact successfully
					
		verifyTextPresent(driver, "Contact successfully saved");
		verifyTextPresent(driver, contactname);
		
		
	}

	private String contactname = getUniqueString("contact name");
	private String category = "";
	private String status = "";
	
}
