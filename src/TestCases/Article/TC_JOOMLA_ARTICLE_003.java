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

	public class TC_JOOMLA_ARTICLE_003 extends AbstractTest {
		 
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
		public void Verify_publish_article() throws Exception {
				LoginPage login = new LoginPage(driver);
				AdministratorPage adminpage = login.Do(Config.username_home,Config.password_home);
				
				
				// Navigate to Article page from Administrator page
				ArticlePage navpage = adminpage.NavigateArticle();
								
				//Open New Article page
				NewArticlePage newart = navpage.OpenNewArt();
				
				//save article with name
				ArticlePage saveart = newart.createnewart(title_name, body_text);
				
				//Filter article
				saveart.FilterArticle(title_name);
				
				//Publish article
				saveart.PublishArticle();
				
				//Verify article is published
				saveart.IsTextPresent("1 article published.");
				
				WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
				foundElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody" + expectedText + "title_name")));
}
		private String title_name = getUniqueString("thienhoang");
		private String body_text = "thienhoang";
		
	}