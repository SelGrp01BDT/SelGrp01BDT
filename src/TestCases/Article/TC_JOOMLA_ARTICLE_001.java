package TestCases.Article;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import Common.AbstractTest;
import Common.BrowserExecution;
import Common.Config;
import Pages.AdministratorPage;
import Pages.ArticlePage;
import Pages.LoginPage;
import Pages.NewArticlePage;
 
public class TC_JOOMLA_ARTICLE_001 extends AbstractTest {
 
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
	public void Verify_create_new_article() throws Exception {
			LoginPage login = new LoginPage(driver);
			AdministratorPage adminpage = login.Do(Config.username_home,Config.password_home);
			
			// Navigate to Article page from Administrator page
			ArticlePage articlepage = adminpage.NavigateArticle();
							
			//Open New Article page
			NewArticlePage newart = articlepage.OpenNewArt();
			
			//Enter name
			ArticlePage saveart = newart.createnewart(title_name, body_text);
			
			//verify create contact successfully
			saveart.IsTextPresent("Article successfully saved");
			
			
}				
	private String title_name = getUniqueString("thienhoang");
	private String body_text = "thienhoang";
    
  }
 