package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArticlePage {

private WebDriver driver;

public ArticlePage(WebDriver driver)
{ 
    this.driver = driver;

}

public NewArticlePage OpenNewArt(){
	//2. click on Article Manager sub menu
	driver.findElement(By.xpath("//li[@id='toolbar-new']//span[@class='icon-32-new']")).click();

	//3. return ArticlePage PageObject
	return new NewArticlePage(driver);

	
}


}