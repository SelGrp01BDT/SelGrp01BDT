package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.AbstractPage;
public class NewArticlePage extends AbstractPage {

			private WebDriver driver;

		public NewArticlePage(WebDriver driver)
		{ 
		    this.driver = driver;

		}
		
	public ArticlePage createnewart (String Titlename, String Textbody, String Category, String Status ) {
		
		driver.findElement(By.xpath(TitleXpath)).sendKeys(Titlename);
		
		//Select from category list box
		Select category = new Select(driver.findElement(By.xpath(CategoryXpath)));
		category.selectByVisibleText(Category);
		Select status = new Select(driver.findElement(By.xpath(StatusXpath)));
		status.selectByVisibleText(Status);
		
		//enter text to Text area
		WebElement bodyIframe = driver.findElement(By.tagName("iframe"));
		//swith to iframe first
		driver.switchTo().frame(bodyIframe); 
		WebElement mce = driver.findElement(By.id("tinymce"));
		mce.sendKeys(Textbody);
		//switch to default frame
		driver.switchTo().defaultContent();
		
		
		 //click Save and close button
		  driver.findElement(By.xpath(SavebntXpath)).click();
		  
		return new ArticlePage(driver);		
	}
	
	private String TitleXpath = "//input[@id='jform_title']"; 
	private String CategoryXpath = "//select[@id='jform_catid']";
	private String SavebntXpath = "//div[@id='toolbar']//span[@class='icon-32-save']";
	private String StatusXpath= "//*[@id='jform_state']";

}
