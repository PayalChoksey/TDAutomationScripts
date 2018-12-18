package TDWebTest.LoginPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TDWebTest.GlobalProperties.TDWeb_GlobalSetup;

public class LoginTest extends TDWeb_GlobalSetup{
	
	@Parameters({"email","password"})
	@Test (priority = 1)
	public void LoginWithValidCredentials(String email, String password) throws IOException {
		
		// Initialize test reporting
		test = report.startTest("Login to Time Doctor ", "Verify that user can login to Time Doctor");
		
		// Get current URL and expected URL
		String currentURL = driver.getCurrentUrl();
		String pageTitle = driver.getTitle();
		String expectedPageTitle = "Login to Time Doctor";
		
		// Verify that user is currently at base URL
		Assert.assertTrue(pageTitle.equals(expectedPageTitle));
		test.log(LogStatus.PASS, "Starting location is correct " + expectedPageTitle);	
		
		LoginObjects loginEl = new LoginObjects(driver);
		
		loginEl.emailField().sendKeys(email);
		loginEl.passwordField().sendKeys(password);
		loginEl.signinBtn().click();
		
		
		Assert.assertTrue(driver.getCurrentUrl().contains("/#/dashboard") || driver.getCurrentUrl().contains("/#/dashboard_individual"));
		test.log(LogStatus.PASS, "Successfully redirected to " + currentURL);
		report.endTest(test);
	}
}
