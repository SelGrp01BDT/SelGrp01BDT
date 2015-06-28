package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Config {

	public static String url_home = "http://localhost/JoomlaTest/administrator/index.php";
	public static String url = "http://192.168.190.135/Joomla_2.5.28/administrator/index.php";
	public static String username_home = "admin";
	public static String password_home = "123456";

	public static void OpenSite(String url) {

		// instantiate FirefoxDriver and navigate to Joomla
		WebDriver driver = new FirefoxDriver();

		// navigate to joomla
		driver.navigate().to(url);
	}

}
