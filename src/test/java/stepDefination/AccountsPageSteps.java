package stepDefination;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountPage;
import pages.LoginPage;

public class AccountsPageSteps {
	
	LoginPage login=new LoginPage(DriverFactory.getDriver());
	private AccountPage accountspage;

	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable dataTable) {

		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		accountspage=login.doLogin(username, password);

	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
      
		String title=accountspage.getAccountsPageTitle();
		System.out.println("Accounts Page Title is: " + title);
		
	}

	@Then("User gets accounts section")
	public void user_gets_accounts_section(DataTable dataTable) {
		
		List<String>expectedAccountsSectionList=dataTable.asList();
		System.out.println("Expected Accounts section List is: " + expectedAccountsSectionList);
		
		List<String> actualAccountsSectionList=accountspage.getAccountSectionHeaderList();
		System.out.println("Actaul Accounts section List is: " + actualAccountsSectionList);
		
		Assert.assertTrue(expectedAccountsSectionList.containsAll(actualAccountsSectionList));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer epectedSectionCount) {
      
		int sectionCount=accountspage.getAccountSectionCount();
		Assert.assertTrue(sectionCount==epectedSectionCount);
		
	}

}
