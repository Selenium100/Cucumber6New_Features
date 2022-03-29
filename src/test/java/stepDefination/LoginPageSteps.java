package stepDefination;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {
	
	private static String title;
	LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    
		 
		title=loginPage.getTitle();
		System.out.println("Login Page title is : " + title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	    
		
		Assert.assertTrue(title.equals(expectedTitle));
	}

	@Then("Forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	   
		boolean flag=loginPage.isForgotPasswordExist();
		Assert.assertTrue(flag);
		
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
	    
		loginPage.enterUsername(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	   
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    
		loginPage.clickLoginButton();
	}

	


}
