package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {
	
	public static void OpenSite (String Url)
	{
	
	        // instantiate FirefoxDriver and navigate to Joomla
			WebDriver driver = new FirefoxDriver();

			// navigate to joomla
			driver.navigate().to(Url);
	}
			
    public String url = "http://192.168.190.135/Joomla_2.5.28/administrator/index.php";
}