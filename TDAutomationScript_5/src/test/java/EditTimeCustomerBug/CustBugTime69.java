package EditTimeCustomerBug;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CustBugTime69 extends TIME69{

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
			@Test (priority = 3, description="Screenshots removed after editing time")
			public void workingslot() throws IOException, InterruptedException
			{
				Time69customerbug();
			}
			
			@Parameters({"email","password"})
			@Test (priority = 2, description="Login with Valid credentials")

			public void logindetails(String email, String password) throws IOException, InterruptedException
			{
				login(email,password);
			}
}

