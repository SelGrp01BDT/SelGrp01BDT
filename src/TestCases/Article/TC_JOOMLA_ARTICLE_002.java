package TestCases.Article;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.AbstractTest;
import Common.BrowserExecution;
import Common.Config;
import Pages.AdministratorPage;
import Pages.ArticlePage;
import Pages.LoginPage;
import Pages.NewArticlePage;

	public class TC_JOOMLA_ARTICLE_002 extends AbstractTest {
		 
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
		public void Verify_updte_article() throws Exception {
				LoginPage login = new LoginPage(driver);
				AdministratorPage adminpage = login.Do(Config.username_home,Config.password_home);
				
				
				// Navigate to Article page from Administrator page
				ArticlePage artpage = adminpage.NavigateArticle();
								
				//Open New Article page
				NewArticlePage newart = artpage.OpenNewArt();
				
				//save article with name
				newart.createnewart(title_name, body_text, category, status);
				
				//Filter article
				artpage.FilterArticle(title_name);
				
								//Open  edit Article
				artpage.OpenEditArticle();
				
				//save article with edit name
				newart.createnewart(title_name_edit, body_text, category, status);
								
				//verify create contact successfully
				artpage.IsTextPresent("Article successfully saved");
	}
		
		private String title_name = getUniqueString("thienhoang");
		private String body_text = "thienhoang";
		private String title_name_edit = getUniqueString("thienhoang1");
		private String category = "- Sample Data-Articles";
		private String status= "Unpublished";
		
		}
	    

