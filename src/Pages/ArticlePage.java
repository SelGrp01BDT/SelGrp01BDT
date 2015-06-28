package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage {

private WebDriver driver;

public ArticlePage(WebDriver driver)
{ 
    this.driver = driver;

}

//return ArticlePage
public ArticlePage NavigateArticle()
{
	//1. hover over Content link menu
	driver.findElement(By.linkText("Content")).click();
	
	//2. click on Article Manager sub menu
	driver.findElement(By.linkText("Article Manager")).click();
	
	//3. return ArticlePage PageObject
	return this;

}
public NewArticlePage OpenNewArt(){
	//2. click on Article Manager sub menu
	driver.findElement(By.xpath("//li[@id='toolbar-new']//span[@class='icon-32-new']")).click();

	//3. return ArticlePage PageObject
	return new NewArticlePage(driver);
}

public ArticlePage FilterArticle(String Articlename){
	//Enter article to filter
	driver.findElement(By.xpath(FilterbtnXpath)).sendKeys(Articlename);
	//Click Search button
	driver.findElement(By.xpath(SearchbtnXpath)).click();
	//Check on checkbox of that title
	driver.findElement(By.xpath(CkbXpath)).click();
	return this;
}

public ArticlePage OpenEditArticle(){	
	//click edit button
	driver.findElement(By.xpath(EditbtnXpath)).click();	
	return this;
}

public ArticlePage PublishArticle(){
	driver.findElement(By.xpath(PublishbtnXpath)).click();	
	return this;
}

public boolean IsTextPresent(String textToBeVerified)
{
try
      {
      if (driver.findElement(By.xpath("//*[contains(.,'" + textToBeVerified + "')]")) != null)   
    	  return true;
      else 
    	  return false;

} 
catch (Exception ex)
{
return false;
}	
}

private String FilterbtnXpath = "//input[@id='filter_search']";
private String SearchbtnXpath = "//div[@class='filter-search fltlft']//button[contains(text(),'Search')]";
private String CkbXpath = "//input[@id='cb0']";
private String EditbtnXpath = "//li[@id='toolbar-edit']//span[@class='icon-32-edit']";
private String PublishbtnXpath = "//li[@id='toolbar-publish']//span[@class='icon-32-publish']";
}