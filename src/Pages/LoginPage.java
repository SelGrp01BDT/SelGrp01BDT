package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
 
    // return AdministratorPage PageObject
    public AdministratorPage Do(String UserName, String Password)
    {
        // 1. steps to login to the Flights application
        driver.findElement(By.id("mod-login-username")).sendKeys(UserName);
        driver.findElement(By.id("mod-login-password")).sendKeys(Password);
        driver.findElement(By.linkText("Log in")).click();
 
        // 2. return AdministratorPage PageObject
        return new AdministratorPage(driver);
    }
    
}
