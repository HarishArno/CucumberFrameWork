package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionBase {
	
	public static WebDriver driver;
	
	@Given("User opens the {string} browser")
	public void launchBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			Assert.fail("Given browser name is not supported");
		}
		driver.get("https://www.saucedemo.com/v1/");
	}
	
	@After
	public void testTearDown() {
		driver.quit();
	}
}
