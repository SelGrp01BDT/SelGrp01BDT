package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserExecution {

	public void openSite(String url) {
		driver.get(url);
	}

	public void closeSite()
	{
		driver.quit();
	}
	
	private WebDriver driver = new FirefoxDriver();

}
