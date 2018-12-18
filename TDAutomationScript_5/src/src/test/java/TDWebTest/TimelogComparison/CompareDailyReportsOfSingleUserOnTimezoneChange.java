package TDWebTest.TimelogComparison;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TDWebTest.CompanySettings.ChangeCompanyTimezoneTest;
import TDWebTest.GlobalProperties.TDWeb_GlobalSetup;
import TDWebTest.LoginPage.LoginTest;

public class CompareDailyReportsOfSingleUserOnTimezoneChange extends TDWeb_GlobalSetup {
	
	@Parameters({"email","password"})
	@Test
	public void Login(String email, String password) throws IOException {
		
		LoginTest login = new LoginTest();
		login.LoginWithValidCredentials(email, password);
		
	}
	
	@Test(dependsOnMethods="Login")
	public void CompareWorkLogByDay() throws InterruptedException, IOException {
		
		ChangeCompanyTimezoneTest change = new ChangeCompanyTimezoneTest();
		change.ChangeCompanyTimezone();
		
		CompareDailyReportsOfSingleUser compareReports = new CompareDailyReportsOfSingleUser();
		compareReports.CompareWorkLogByDay();
		
	}	
	
}
