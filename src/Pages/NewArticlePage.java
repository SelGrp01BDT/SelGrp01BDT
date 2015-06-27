package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class NewArticlePage {

			private WebDriver driver;

		public NewArticlePage(WebDriver driver)
		{ 
		    this.driver = driver;

		}
		
	public ArticlePage createnewart (String Titlename, String Textbody ) {
		
		driver.findElement(By.xpath("//input[@id='jform_title']")).sendKeys(Titlename);
		//new Select (driver.findElement(By.xpath("//input[//select[@id='jform_catid']]"))).selectByVisibleText("- - Fruit Shop Site");
		Select select = new Select(driver.findElement(By.xpath("//select[@id='jform_catid']")));
		select.selectByVisibleText("- - Fruit Shop Site");
		
		return new ArticlePage(driver);
	}
	

}
