package EditTimeCustomerBug;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustBugTime68 extends TIME68{

	// Calling the method from the TDWeb_001 

			@BeforeTest
			public void propCalling() throws IOException
			{
				
				IntializingProperties();
			}
			
		// Calling the method from TIME5 to launch the application on various browser	
			@Test (priority = 1, description="Navigates to the time doctor registration page")

			public void browserCalling() throws IOException, InterruptedException
			{
				TDLoginPage();
			}
			@Test (priority = 3, description="New Edit Time Page doesn't fill the not working slot if we try to add a manual entry but it just adds a random hour")
			public void workingslot() throws IOException, InterruptedException
			{
				Time62customerbug();
			}
			
			@Parameters({"email","password"})
			@Test (priority = 2, description="Login with Valid credentials")

			public void logindetails(String email, String password) throws IOException, InterruptedException
			{
				login(email,password);
			}
}

