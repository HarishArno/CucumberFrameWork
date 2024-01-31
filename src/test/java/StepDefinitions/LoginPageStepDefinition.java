package StepDefinitions;

import org.openqa.selenium.WebDriver;

import PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPageStepDefinition {

	StepDefinitionBase stepDefinitionBase = new StepDefinitionBase();
	WebDriver driver = stepDefinitionBase.driver;
	LoginPage loginPage = new LoginPage(driver);

	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {
		loginPage.verifyUserInLoginPage();
	}

	@Then("User Enters {string} and {string} and clicks Login Button")
	public void user_enters_and_and_clicks_login_button(String username, String password) {
		loginPage.enterUserNameAndPassword(username, password);
	}

	@Then("User should be landed on the Home Page")
	public void user_should_be_landed_on_the_home_page() throws InterruptedException {
		Thread.sleep(2500);
		loginPage.verifyUserIsLoggedIn();
	}
}
