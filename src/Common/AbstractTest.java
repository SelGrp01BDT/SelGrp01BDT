package Common;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractTest {

    protected WebDriver driver;

	// Verify a message is presented on a page
	public static void verifyTextPresent(WebDriver driver, String text) throws Exception{
		String result = driver.findElement(By.tagName("body")).getText();
		Boolean check = result.contains(text);
		if (check == false) {
			throw new Exception (text + " (is not present)");
		}
	}
	
	

	
	
	// Generate a unique string
	public static String getUniqueString(String basestring) {
		
		int day, month, year;
	      int second, minute, hour;
	      GregorianCalendar date = new GregorianCalendar();

	      day = date.get(Calendar.DAY_OF_MONTH);
	      month = date.get(Calendar.MONTH);
	      year = date.get(Calendar.YEAR);

	      second = date.get(Calendar.SECOND);
	      minute = date.get(Calendar.MINUTE);
	      hour = date.get(Calendar.HOUR);
		
		return basestring + day + month + year + second + minute + hour;
	}
    
}
