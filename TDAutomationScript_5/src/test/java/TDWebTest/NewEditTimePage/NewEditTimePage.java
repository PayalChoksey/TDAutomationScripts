package TDWebTest.NewEditTimePage;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;



public class NewEditTimePage extends TDWeb_006{
	
	// Intializing the Properties of Config and Login 
	@BeforeTest
	public void propCalling() throws IOException
	{
		
		IntializingProperties();
	}
	@Parameters({"browser"})
	@Test(priority = 1, description = " Launching the Browser and Application")
	public void differentbrowser(String browser) throws IOException
	{
		LaunchApp(browser);
	}	
	
	@Parameters({"email","password"})
	@Test (priority = 2, description="Login with Valid credentials")

	public void logindetails(String email, String password) throws IOException, InterruptedException
	{
		login(email,password);
	}
	
	@Test (priority = 3, description="Navigate to Edit Time Page from left navigation bar" )

	public void navedittime() throws IOException
	{
		editnavigation();
	}
	

	@Test (priority = 4, description="Checking the Cancel button" )

	public void UserDropList() throws IOException, InterruptedException
	{
		droplistuser();
	}
	@Test (priority = 5, description="Checking the Cancel button" )

	public void canceladdtime() throws IOException, InterruptedException
	{
		AddtimeCancel();
	}
	
	@Test (priority = 6, description="Saving time wih invalid data - Project Name" )

	public void ProjectInvalid() throws IOException, InterruptedException
	{
		InvalidProjectName();
	}
	@Test (priority = 7, description="Entering wrong project name" )

	public void TaskInvalid() throws IOException, InterruptedException
	{
		InvalidTaskName();
	}
	
	@Test (priority = 8, description="Entering invalid data in project name" )

	public void InvalidProject() throws IOException, InterruptedException
	{
		InvalidDataProjectName();
	}
	
	@Test (priority = 9, description="Editing time Manually" )

	public void EditManualTime() throws IOException, InterruptedException
	{
		manualedittime();
	}
	
	@Test (priority = 10, description="Selecting the Date" )

	public void Date() throws IOException, InterruptedException
	{
		datebutton();
	}
	
	@Test (priority = 11, description="Selecting the Time Line Page" )

	public void TimeView() throws IOException, InterruptedException
	{
		TimeLineView();
	}
	

	
	
}
