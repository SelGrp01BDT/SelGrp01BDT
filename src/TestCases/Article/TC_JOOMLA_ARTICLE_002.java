package TestCases.Article;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pages.AdministratorPage;
import Pages.ArticlePage;
import Pages.LoginPage;
import Pages.NewArticlePage;

public class TC_JOOMLA_ARTICLE_002 {

	public static WebDriver driver;
	 
	@Test
	public static void CreateArticle() {
		
		// instantiate FirefoxDriver and navigate to Joomla
			
	            driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
				// navigate to joomla
				driver.navigate().to(
						"http://192.168.190.135/Joomla_2.5.28/administrator/index.php");
				;

				// instantiate LoginPage
				LoginPage loginpage = new LoginPage(driver);

				// Login.Do returns the AdministratorPage PageObject
				AdministratorPage adminpage = loginpage.Do("Selenium_Team1", "123456");
				
				// Navigate to Article page from Administrator page
				ArticlePage navpage = adminpage.NavigateArticle();
								
				//Open New Article page
				NewArticlePage newart = navpage.OpenNewArt();
				
				//Enter name
				ArticlePage saveart = newart.createnewart("ThienHoangfhj1", "HoangThien");
				
				//Navigate to Create article page
				
				
				
				//verify create contact successfully
				saveart.IsTextPresent("Article successfully saved");
	}
	
	
	@AfterMethod
	public void afterMethod() {
					  
	// Close the driver
		driver.quit();
	 }
	    
	  }
	 
