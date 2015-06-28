package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public abstract class AbstractPage {

	protected WebDriver driver;
 
    public void printText(String textBoxId, String text) {
        WebElement textBox = driver.findElement(By.id(textBoxId));
        textBox.clear();
        textBox.sendKeys(text);
    }
 
    public void click(String control) {
        WebElement button = driver.findElement(By.xpath(control));
        button.click();
    }
    
    public void navigateMenuBar(String strMenuBar)
    {

    String linkName = ".//*[@id='menu']//a[contains(text(),\"{0}\")]";
    String [] names = strMenuBar.split(">");

    for(int i = 0; i<=names.length-1;i++)
    {
     String link = linkName.replace("{0}", names[i]);
     driver.findElement(By.xpath(link)).click();
    }
    }
  	
    public void selectdropDownListItem(By dropdowlist, String item) {
		WebElement dropDownListBox = driver.findElement(dropdowlist);
		Select clickItem = new Select(dropDownListBox);
		clickItem.selectByVisibleText(item);
    }
	
}
