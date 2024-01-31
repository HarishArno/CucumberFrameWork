package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import StepDefinitions.StepDefinitionBase;

public class LoginPage extends StepDefinitionBase {
	
	StepDefinitionBase stepDefinitionBase = new StepDefinitionBase();
	WebDriver driver = stepDefinitionBase.driver;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement loginLogo;
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement usernameField;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class='product_label']")
	WebElement loginValidation;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void verifyUserInLoginPage() {
		boolean loginValidation = loginLogo.isDisplayed();
		Assert.assertTrue(loginValidation,"User is not in login page");
	}
	
	public void enterUserNameAndPassword(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	public void verifyUserIsLoggedIn() {
		boolean loginValid = loginValidation.isDisplayed();
		Assert.assertTrue(loginValid,"User is not in login page");
	}
}
