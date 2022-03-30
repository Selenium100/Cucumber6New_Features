package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	private static final By emailID = By.id("email");
	private static final By password = By.id("passwd");
	private static final By submitButton = By.id("SubmitLogin");
	private static final By forgotPasswordLink = By.linkText("Forgot your password?");

	public String getTitle() {

		return driver.getTitle();
	}
	
	public boolean isForgotPasswordExist() {
		
		return driver.findElement(forgotPasswordLink).isDisplayed();
	}
	
	public void enterUsername(String userName) {
		
		driver.findElement(emailID).sendKeys(userName);
	}
	
	public void enterPassword(String passwd) {
		
		driver.findElement(password).sendKeys(passwd);
	}
	
	public void clickLoginButton() {
		
		driver.findElement(submitButton).click();
	}
	
	public AccountPage doLogin(String un,String pwd) {
		
		System.out.println("Login with username: " + un + " with Password: " + pwd);
		
		driver.findElement(emailID).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(submitButton).click();
		return new AccountPage(driver);
		
	}

}
