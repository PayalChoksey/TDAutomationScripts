package TDWebTest.TimelogComparison;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TDWebTest.GlobalProperties.GlobalObjects;
import TDWebTest.GlobalProperties.TDWeb_GlobalSetup;
import TDWebTest.LoginPage.LoginTest;
import TDWebTest.TimeUse.TimeUseFunctions;
import TDWebTest.Timesheet.TimesheetFunctions;

public class CompareWeeklyReportsOfAllUsers extends TDWeb_GlobalSetup{
	
	@Parameters({"email","password"})
	@Test
	public void Login(String email, String password) throws IOException {
		
		LoginTest login = new LoginTest();
		login.LoginWithValidCredentials(email, password);
		
	}
	
	@Test(dependsOnMethods="Login")
	public void CompareWorkLogByDay() throws InterruptedException, IOException {
		
		GlobalObjects dateSelection = new GlobalObjects(driver);
		
		// Initialize test reporting
		test = report.startTest("Timesheet Report Page ", "Get time log of all users on Timesheet report page from previous days");
		TimesheetFunctions tsFunc = new TimesheetFunctions(dateSelection.filterWeekBtn(), dateSelection.previousWeekBtn());
		tsFunc.GetTimesheetReportForAllUsers();
				
		test = report.startTest("Time Use Report Page ", "Get time log of all users on Time Use report page from previous days");
		TimeUseFunctions tuFunc = new TimeUseFunctions(dateSelection.filterWeekBtn(), dateSelection.previousWeekBtn());
		tuFunc.GetTimeUseReportForAllUsers();
		
		// Initialize test reporting
		test = report.startTest("Weekly Timelogs Comparison", "Compare timelogs from Timesheet and Time Use pages");
		if(tsFunc.tsData.isEmpty() && tuFunc.tuData.isEmpty()) {
			test.log(LogStatus.PASS, "PASS: There are no time logs for all Timesheet and Time use pages");
		} else {
			// compare worklogs
			Assert.assertTrue(tsFunc.tsData.containsAll(tuFunc.tuData));
			Assert.assertTrue(tuFunc.tuData.containsAll(tsFunc.tsData));
			test.log(LogStatus.INFO, "Assert that logs from Timesheet and Time Use pages correctly match");
			test.log(LogStatus.PASS, "PASS: Logs from Timesheet and Time Use pages match");
		} 
	}	
}
