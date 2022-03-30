package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver=driver;	
	}
	
	private By accountSections=By.cssSelector("div#center_column span");
	
	
	public int getAccountSectionCount() {
		
		return driver.findElements(accountSections).size();
	}
	
	public String getAccountsPageTitle() {
		
		return driver.getTitle();
	}
	
	public List<String> getAccountSectionHeaderList() {
		
		List<WebElement> accountSectionList=driver.findElements(accountSections);
		List<String> accountList=new ArrayList<String>();
		
		for(WebElement ele:accountSectionList) {
			
			String txt=ele.getText();
			System.out.println(txt);
			accountList.add(txt);
		}
		
		return accountList;
	}
	

}
