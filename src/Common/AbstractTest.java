package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AbstractTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
	
}
