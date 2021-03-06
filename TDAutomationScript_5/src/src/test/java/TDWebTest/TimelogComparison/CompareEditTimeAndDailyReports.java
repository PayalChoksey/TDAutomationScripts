package TDWebTest.TimelogComparison;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TDWebTest.CompanySettings.ChangeCompanyTimezoneTest;
import TDWebTest.EditTimePage.EditTimePageFunctions;
import TDWebTest.GlobalProperties.GlobalObjects;
import TDWebTest.GlobalProperties.TDWeb_GlobalSetup;
import TDWebTest.LoginPage.LoginTest;
import TDWebTest.TimeUse.TimeUseFunctions;
import TDWebTest.Timeline.TimelineFunctions;
import TDWebTest.Timesheet.TimesheetFunctions;

public class CompareEditTimeAndDailyReports extends TDWeb_GlobalSetup {
	
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
		
		EditTimePageFunctions etFunc = new EditTimePageFunctions();
		etFunc.GetTotalTimeWorked();
		
		GlobalObjects dateSelection = new GlobalObjects(driver);
		
		test = report.startTest("Timesheet Report Page ", "Get time log of specific user on Timesheet report page from previous days");
		TimesheetFunctions tsFunc = new TimesheetFunctions(dateSelection.filterDayBtn(), dateSelection.previousDayBtn());
		tsFunc.GetTimesheetReportForSingleUser();
		
		test = report.startTest("Time Use Report Page ", "Get time log of specific users on Time Use report page from previous days");
		TimeUseFunctions tuFunc = new TimeUseFunctions(dateSelection.filterDayBtn(), dateSelection.previousDayBtn());
		tuFunc.GetTimeUseReportForSingleUser();
		
		test = report.startTest("Timeline Report Page ", "Get time log of specific users on Timeline report page from previous days");		
		TimelineFunctions tlFunc = new TimelineFunctions();
		tlFunc.GetTimelineReportForSingleUser();
		
		
		// Initialize test reporting
		test = report.startTest("Daily Timelogs Comparison", "Compare timelogs from Timesheet, Time Use and Timeline Report pages");
		if(tsFunc.tsData.isEmpty() && tuFunc.tuData.isEmpty()) {
			test.log(LogStatus.PASS, "PASS: There are no time logs for all Timesheet, Time use and Timeline Report pages");
		} else {
			// compare worklogs
			Assert.assertTrue(tsFunc.tsData.containsAll(tuFunc.tuData));
			Assert.assertTrue(tsFunc.tsData.containsAll(tlFunc.tlData));
			Assert.assertTrue(tsFunc.tsData.containsAll(etFunc.etData));
			
			Assert.assertTrue(tuFunc.tuData.containsAll(tsFunc.tsData));
			Assert.assertTrue(tuFunc.tuData.containsAll(tlFunc.tlData));
			Assert.assertTrue(tuFunc.tuData.containsAll(etFunc.etData));
			
			Assert.assertTrue(tlFunc.tlData.containsAll(tsFunc.tsData));
			Assert.assertTrue(tlFunc.tlData.containsAll(tuFunc.tuData));
			Assert.assertTrue(tlFunc.tlData.containsAll(etFunc.etData));
			
			Assert.assertTrue(etFunc.etData.containsAll(tsFunc.tsData));
			Assert.assertTrue(etFunc.etData.containsAll(tlFunc.tlData));
			Assert.assertTrue(etFunc.etData.containsAll(tuFunc.tuData));
			
			test.log(LogStatus.INFO, "Assert that logs from Timesheet, Time Use and Timeline Report pages correctly match");
			test.log(LogStatus.PASS, "PASS: Logs from Timesheet, Time Use and Timeline Reports pages should match");
		} 
		
		
	}	
	
}
