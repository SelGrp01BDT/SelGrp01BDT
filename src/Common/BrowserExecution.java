package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class BrowserExecution {

	public static String url_home = "http://localhost/JoomlaTest/administrator/index.php";
	public static String url = "http://192.168.190.135/Joomla_2.5.28/administrator/index.php";
	
	protected static WebDriver driver;
	protected String testUrl, browser;
	
	public static void navigateJoomla(WebDriver driver) {
		driver.get(url_home);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public static void closeJoomla(WebDriver driver)
	{
		driver.close();
	}
}
