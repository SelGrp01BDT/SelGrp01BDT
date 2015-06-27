package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
}
