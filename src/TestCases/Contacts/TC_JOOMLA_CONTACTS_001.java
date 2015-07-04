package TestCases.Contacts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import Pages.AdministratorPage;
import Pages.LoginPage;
import Pages.ContactsPage;
import Pages.ContactPage;

public class TC_JOOMLA_CONTACTS_001 {
	
	public static WebDriver driver;
	public static String contactname = "Test Contact 1111";
	public static String category = "- - Park Site";
	public static String successlabel = "Contact successfully saved";
	
	  @BeforeMethod
	  public void beforeMethod() {
		   
	      // Create a new instance of the Firefox driver
	 
	      driver = new FirefoxDriver();
	 
	      //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	 
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
	    }
	
	  @Test

	
		public static void CreateContacts() {
			 
	      
			// navigate to joomla
			driver.navigate().to("http://localhost/Joomla/administrator/index.php");
		
			// instantiate LoginPage
			LoginPage loginpage = new LoginPage(driver);

			// Login.Do returns the AdministratorPage PageObject
			AdministratorPage adminpage = loginpage.Do("admin", "admin");
			
			// Open Contacts Page
			ContactsPage contactspage = adminpage.OpenContactsPage();
			
		    // Open Create Contact page
			ContactPage contactpage = contactspage.OpenContactPage();
			
			// Input Name, Category the click Save&Close button
			contactspage= contactpage.CreateNewContact(contactname,category);
			
			// verify create contact successfully
			contactspage.IsTextPresent(successlabel);
			
			// verify create contact successfully
			contactspage.IsTextPresent(contactname);
		}

	  @AfterMethod
	  public void afterMethod() {
		  
		  // Close the driver
		 
		   driver.quit();
		 
		  }
}
