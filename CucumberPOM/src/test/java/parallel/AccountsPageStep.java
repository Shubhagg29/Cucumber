package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AccountPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AccountsPageStep {
 
	private LoginPage loginPage= new LoginPage(DriverFactory.getDriver());
	private AccountPage accountPage;
@Given("user has already logged in to application")
public void user_has_already_logged_in_to_application(DataTable dataTable) {

    List<Map<String, String>> credList=dataTable.asMaps();
   String username= credList.get(0).get("username");
   String password= credList.get(0).get("password");
   DriverFactory.getDriver()
	.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
   
   accountPage =  loginPage.doLogin(username, password);
}   

@Given("user is on Accounts page")
public void user_is_on_accounts_page() {
	String Title=accountPage.getAccountsPageTitle();
}

@Then("user gets accounts section")
public void user_gets_accounts_section(DataTable dataTable) {
List<String>ExpectedList=dataTable.asList();
System.out.println("Expected List :: "+ ExpectedList);
	
List<String> ActualList=	accountPage.getAccountsectionList();
System.out.println("ActualList  :: "+ ActualList);	
Assert.assertTrue(ActualList.containsAll(ExpectedList));


}

@Then("accounts section count should be {int}")
public void accounts_section_count_should_be(Integer int1) {
	Assert.assertTrue(accountPage.getAccountSectionCount()==int1);
	System.out.println(accountPage.getAccountSectionCount());
	
	 
}

}
