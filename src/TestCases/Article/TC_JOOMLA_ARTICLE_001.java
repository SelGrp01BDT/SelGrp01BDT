package TestCases.Article;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Pages.AdministratorPage;
import Pages.ArticlePage;
import Pages.LoginPage;
import Pages.NewArticlePage;
 
public class TC_JOOMLA_ARTICLE_001 {
 
public WebDriver driver;
 
@Test
public static void CreateArticle() {
	
	// instantiate FirefoxDriver and navigate to Joomla
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
			// navigate to joomla
			driver.navigate().to(
					"http://192.168.190.135/Joomla_2.5.28/administrator/index.php");
			;

			// instantiate LoginPage
			LoginPage loginpage = new LoginPage(driver);

			// Login.Do returns the AdministratorPage PageObject
			AdministratorPage adminpage = loginpage.Do("Selenium_Team1", "123456");
			
			ArticlePage navpage = adminpage.NavigateArticle();
							
			NewArticlePage newart = navpage.OpenNewArt();
			
			ArticlePage saveart = newart.createnewart("ThienHoang", "HoangThien");
					
  // Close the driver
 
    
  }
 
}