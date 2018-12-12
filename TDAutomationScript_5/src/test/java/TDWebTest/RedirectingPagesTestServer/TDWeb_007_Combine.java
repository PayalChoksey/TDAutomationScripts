/**
* Project Name : Time Doctor Automation Framework 
* Author : Time Doctor QA Team
* Version : V 1.0 
* Reviewed By : Sandy
* Date of Creation : 08/31/2018
* Modification History : 
* Date of change : 09/03/2018 
* Version : V 1.1 
* changed function :  
* change description : Added all the standards and modified the code
* Modified By : Payal Choksey
*/
package TDWebTest.RedirectingPagesTestServer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import TDWebTest.CaptureScreenShot.UtilityRegistration;



public class TDWeb_007_Combine {
	public static Properties Config=null;
	public static Properties LoginOR=null;
	public static Properties RegOR=null;
	public static WebDriver tdweb = null;
	public static String browserName = "Firefox";
	public static String currentURL;
	public static String verifyLogIn;
	ExtentTest test;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	
	// Declaring the Property files from where the value or objects will be fetched
	
	public void IntializingProperties() throws IOException
	{
		
		Config= new Properties();
		FileInputStream config =new FileInputStream(System.getProperty("user.dir")+"/src//test//resources//Source//Config.properties");
		Config.load(config);
		LoginOR= new Properties();
		FileInputStream loginor =new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Source//LoginPage.properties");
		LoginOR.load(loginor);
		RegOR= new Properties();
		FileInputStream regor =new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Source//RegistrationPage.properties");
		RegOR.load(regor);
	}
	
	// Calling the application in various browser Chrome, Safari and Firefox. Note only chrome is implemented at the moment
	
	public void ValidCredentials() throws InterruptedException, IOException
	{
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/src//test//resources//Reports//RedirectingPages//RedirectingPages.html");
		test = report.startTest("TD Valid Login", "Entering with Valid Data");
				
		tdweb.findElement(By.xpath(LoginOR.getProperty("Email"))).sendKeys("payal+42@staff.com");
		tdweb.findElement(By.xpath(LoginOR.getProperty("Password"))).sendKeys("payal123");
		UtilityRegistration.capturescreenshot(tdweb, "Entering Credentials");
		tdweb.findElement(By.xpath(LoginOR.getProperty("Signinbtn"))).click();
		test.log(LogStatus.INFO, "Entering the valid credentials");
		tdweb.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		currentURL=tdweb.getCurrentUrl();
		System.out.println(currentURL);
		test.log(LogStatus.INFO, "Entered valid Credentials");
		test.log(LogStatus.PASS, "User is able to login Sucessfully");
	//	report.endTest(test);
	//	report.flush();
	}
	
	// Verify Client Link and Logout from Application
	public void ClientsLink() throws InterruptedException, IOException
	{
		test = report.startTest("Client Link", "Verifying to client on Client Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Verification of clicking on Client's Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Client"))).click();
		UtilityRedirectingPage.pausing(); // has been implemented to take screenshot for clients link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Client");
		test.log(LogStatus.PASS, "Sucessfully clicked on Client Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Project and Permanent Task and Logout from Application
	public void ProjectPermanentTaskLink() throws InterruptedException, IOException
	{
		test = report.startTest("Project and Permanent Link", "Verifying to Project and Permanent Task Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Verification of Project and Permanent Task Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("ProjectPermanentLink"))).click();
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Project and Permanent link
		UtilityRedirectingPage.capturescreenshot(tdweb, "ProjectandPermanentTask");
		test.log(LogStatus.PASS, "Sucessfully clicked on Project and Permanent Task");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify User Setting Link and Logout from Application
	public void UserSettingLink() throws InterruptedException, IOException
	{
		test = report.startTest("User Setting Link", "Verifying User Setting Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Verification of User Setting Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("UserSetting"))).click();
		UtilityRedirectingPage.capturescreenshot(tdweb, "UserSetting");
		test.log(LogStatus.PASS, "Sucessfully clicked on User Setting");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
		
	}
	
	// Verify Manage User Link and Logout from Application
	public void ManageUserLink() throws InterruptedException, IOException
	{
		test = report.startTest("Manage User Link", "Verifying Manage User Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Verification of Manager User Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("ManageUsers"))).click();
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Manage Users link
		UtilityRedirectingPage.capturescreenshot(tdweb, "ManageUsers");
		test.log(LogStatus.PASS, "Sucessfully clicked on Manage Users");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Payroll Setting Link and Logout from Application
	public void PayrollSettingLink() throws InterruptedException, IOException
	{
		test = report.startTest("Payroll Setting Link", "Verifying Payroll Setting Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Verification Payroll Setting Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("Payroll"))).click();
		UtilityRedirectingPage.capturescreenshot(tdweb, "PayrollSetting");
		test.log(LogStatus.PASS, "Sucessfully clicked on Payroll Setting");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Payoneer Setting Link and Logout from Application
	public void PayoneerSettingLink() throws InterruptedException, IOException
	{
		test = report.startTest("Payoneer Setting Link", "Verifying Payoneer Setting Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Verification Payoneer Setting Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("Payoneer"))).click();
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Payoneer link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Payoneer");
		test.log(LogStatus.PASS, "Sucessfully clicked on Payoneer Setting");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Work Schedule Link and Logout from Application
	public void WorkScheduleLink() throws InterruptedException, IOException
	{
		test = report.startTest("Work Schedule Link", "Verifying Work Schedule Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Work Schedule Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("WorkSchedule"))).click();
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Work Schedule link
		UtilityRedirectingPage.capturescreenshot(tdweb, "WorkSchedule");
		test.log(LogStatus.PASS, "Sucessfully clicked on WorkSchedule");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Integration Link and Logout from Application
	public void IntegrationLink() throws InterruptedException, IOException
	{
		test = report.startTest("Integration Link", "Verifying Integration Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Integration  Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("YourIntegration"))).click();
		UtilityRedirectingPage.capturescreenshot(tdweb, "Integration");
		test.log(LogStatus.PASS, "Sucessfully clicked on Integration");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Company Integration Link and Logout from Application
	public void CompanyIntegrationLink() throws InterruptedException, IOException
	{
		test = report.startTest("Company Integration Link", "Verifying Integration Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, "Company Integration   Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("CompanyIntegration"))).click();
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Company Integration link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Company Integration");
		test.log(LogStatus.PASS, "Sucessfully clicked on Company Integration");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify API Link and Logout from Application
	public void APILink() throws InterruptedException, IOException
	{
		test = report.startTest("API Link", "Verifying API Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, " API  Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("API"))).click();
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for API link
		UtilityRedirectingPage.capturescreenshot(tdweb, "API");
		test.log(LogStatus.PASS, "Sucessfully clicked on API Link ");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Billing Link and Logout from Application
	public void BillingLink() throws InterruptedException, IOException
	{
		test = report.startTest("Billing Link", "Verifying Billing Link and Logout from Application");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		test.log(LogStatus.INFO, " Billing  Link");
		tdweb.findElement(By.xpath(RegOR.getProperty("Billing"))).click();
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Billing link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Billing");
		test.log(LogStatus.PASS, "Sucessfully clicked on Billing Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink1"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Dashboard Link and Logout from Application
	public void DashboardLink() throws InterruptedException, IOException
	{
		test = report.startTest("Dashboard Link", "Verifying Dashboard Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Dashboard"))).click();
		test.log(LogStatus.INFO, " Dashboard  Link");
		UtilityRedirectingPage.capturescreenshot(tdweb, "Dashboard");
		test.log(LogStatus.PASS, "Sucessfully clicked on Dashboard Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Edit Time Link and Logout from Application
	public void EditTimeLink() throws InterruptedException, IOException
	{
		test = report.startTest("Edit Time Link", "Verifying Edit Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Edit"))).click();
		test.log(LogStatus.INFO, " Edit Time  Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Edit Time link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Edit Time");
		test.log(LogStatus.PASS, "Sucessfully clicked on Edit Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();
	}
	
	// Verify Screenshot Link and Logout from Application
	public void ScreenshotLink() throws InterruptedException, IOException
	{

		test = report.startTest("Screenshot Link", "Verifying Screenshot Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Screenshot"))).click();
		test.log(LogStatus.INFO, " Screenshot  Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Screenshot link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Screenshot");
		test.log(LogStatus.PASS, "Sucessfully clicked on Screenshot Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();	
	}
	
	// Verify Report Link - Time sheet and Logout from Application
	public void TimeSheetLink() throws InterruptedException, IOException
	{
		test = report.startTest("TimeSheet Link", "Verifying Payment Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Timesheet"))).click();
		test.log(LogStatus.INFO, " TimeSheet  Link");
		UtilityRedirectingPage.capturescreenshot(tdweb, "TimeSheet");
		test.log(LogStatus.PASS, "Sucessfully clicked on TimeSheet Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	
	// Verify Time Use Link - Time sheet and Logout from Application
	public void TimeUseLink() throws InterruptedException, IOException
	{
		test = report.startTest("TimeUse Link", "Verifying Payment Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Timeuse"))).click();
		test.log(LogStatus.INFO, " TimeUse  Link");
		UtilityRedirectingPage.capturescreenshot(tdweb, "TimeUse");
		test.log(LogStatus.PASS, "Sucessfully clicked on TimeUse Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	
	// Verify Time Line Link - Time sheet and Logout from Application
	public void TimeLineLink() throws InterruptedException, IOException
	{
		test = report.startTest("TimeLine Link", "Verifying Payment Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Timeline"))).click();
		test.log(LogStatus.INFO, " TimeLine  Link");
		UtilityRedirectingPage.capturescreenshot(tdweb, "TimeLine");
		test.log(LogStatus.PASS, "Sucessfully clicked on TimeLine Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	// Verify Time Use Link - Time sheet and Logout from Application
	public void PoorTimeUseLink() throws InterruptedException, IOException
	{
		test = report.startTest("PoorTimeUse Link", "Verifying Payment Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Poortimeuse"))).click();
		test.log(LogStatus.INFO, " TimeLine  Link");
		UtilityRedirectingPage.capturescreenshot(tdweb, "PoorTimeUse");
		test.log(LogStatus.PASS, "Sucessfully clicked on PoorTimeUse Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	// Verify Web App Link - Time sheet and Logout from Application
	public void WebAppLink() throws InterruptedException, IOException
	{
		test = report.startTest("WebApp Link", "Verifying Payment Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Webapp"))).click();
		test.log(LogStatus.INFO, " WebApp  Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Web App link
		UtilityRedirectingPage.capturescreenshot(tdweb, "WebApp");
		test.log(LogStatus.PASS, "Sucessfully clicked on WebApp Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	// Verify Project Link - Time sheet and Logout from Application
	public void ProjectsLink() throws InterruptedException, IOException
	{
		test = report.startTest("Projects Link", "Verifying Projects Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Projects"))).click();
		test.log(LogStatus.INFO, " Projects  Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Project link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Projects");
		test.log(LogStatus.PASS, "Sucessfully clicked on Projects Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	// Verify Attendance Link - Time sheet and Logout from Application
	public void AttendanceLink() throws InterruptedException, IOException
	{
		test = report.startTest("Attendance Link", "Verifying Attendance Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Attendance"))).click();
		test.log(LogStatus.INFO, " Attendance  Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Attendance link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Attendance");
		test.log(LogStatus.PASS, "Sucessfully clicked on Attendance Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	// Verify GPS Link - Time sheet and Logout from Application
	public void GPSLink() throws InterruptedException, IOException
	{
		test = report.startTest("GPS Link", "Verifying GPS Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Report"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("GPS"))).click();
		test.log(LogStatus.INFO, " GPS  Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for GPS link
		UtilityRedirectingPage.capturescreenshot(tdweb, "GPS");
		test.log(LogStatus.PASS, "Sucessfully clicked on GPS Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	
	// Verify Current Payroll Link and Logout from Application
	public void CurrentPayrollLink() throws InterruptedException, IOException
	{
		test = report.startTest("Current Payroll Link", "Verifying Current Payroll and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
		tdweb.findElement(By.xpath(RegOR.getProperty("Currentpayroll"))).click();
		test.log(LogStatus.INFO, " Current Payroll  Link");
		UtilityRedirectingPage.capturescreenshot(tdweb, "Current Payroll");
		test.log(LogStatus.PASS, "Sucessfully clicked on Current Payroll Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();							
	}
	// Verify Payroll History Link and Logout from Application
		public void PayrollHistoryLink() throws InterruptedException, IOException
		{
			test = report.startTest("Payroll History Link", "Verifying Payroll History Link and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("Payrollhistory"))).click();
			test.log(LogStatus.INFO, " Payroll History  Link");
			UtilityRedirectingPage.capturescreenshot(tdweb, "Payroll History Payroll");
			test.log(LogStatus.PASS, "Sucessfully clicked on Payroll History Payroll Link");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
		
		// Verify Edit Absent / Late Reason and Logout from Application
		public void EditAbsentLink() throws InterruptedException, IOException
		{
			test = report.startTest(" Edit Absent/Late Reason Link", "Verifying Edit Absent/Late Reason and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("EditAbsent"))).click();
			test.log(LogStatus.INFO, " Edit Absent/Late Reason Link");
			UtilityRedirectingPage.pausing();// has been implemented to take screenshot for EditAbsent link
			UtilityRedirectingPage.capturescreenshot(tdweb, "Edit Absent");
			test.log(LogStatus.PASS, "Sucessfully clicked on Edit Absent/Late Reason Link");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
		
		// Verify Review Manual Time and Logout from Application
		public void ReviewManualTimeLink() throws InterruptedException, IOException
		{
			test = report.startTest(" Review Manual Time Link", "Verifying  Review Manual Time and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("Reviewmanual"))).click();
			test.log(LogStatus.INFO, " Review Manual Time  Link");
			UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Review Manual Time link
			UtilityRedirectingPage.capturescreenshot(tdweb, " Review Manual Time");
			test.log(LogStatus.PASS, "Sucessfully clicked on  Review Manual Time Link");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
		
		// Verify Request Payment from client and Logout from Application
		public void RequestPaymentClientLink() throws InterruptedException, IOException
		{
			test = report.startTest(" Request Payment from client Link", "Verifying  Request Payment from client and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("Requestpaymentclient"))).click();
			test.log(LogStatus.INFO, " Request Payment from client Link");
			UtilityRedirectingPage.capturescreenshot(tdweb, " Request Payment from client");
			test.log(LogStatus.PASS, "Sucessfully clicked on  Request Payment from client");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
		
		//Verify Send Payment Link and Logout from Application
		public void SendPaymentLink() throws InterruptedException, IOException
		{
			test = report.startTest(" Send Payment Link", "Verifying Send Paymentt and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("Sendpayment"))).click();
			test.log(LogStatus.INFO, " Send Payment  Link");
			UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Send Payment link
			UtilityRedirectingPage.capturescreenshot(tdweb, "Send Payment");
			test.log(LogStatus.PASS, "Sucessfully clicked on  Send Payment");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
		
		//Verify Request Payment List Link and Logout from Application
		public void RequestPaymentListLink() throws InterruptedException, IOException
		{
			test = report.startTest(" Request Payment List", "Verifying Send Payment and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("Requestpaymentlist"))).click();
			test.log(LogStatus.INFO, " Request Payment List");
			UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Request Payment link
			UtilityRedirectingPage.capturescreenshot(tdweb, " Request Payment");
			test.log(LogStatus.PASS, "Sucessfully clicked on  Request Payment");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
				
		//Verify Request Payment History Link and Logout from Application
		public void RequestPaymentHistoryLink() throws InterruptedException, IOException
		{
			test = report.startTest(" Request Payment History Link", "Request Payment History and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("Requestpaymenthistory"))).click();
			test.log(LogStatus.INFO, " Request Payment History  Link");
			UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Request Payment History link
			UtilityRedirectingPage.capturescreenshot(tdweb, " Request Payment History");
			test.log(LogStatus.PASS, "Sucessfully clicked on  Request Payment History");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
				
		//Verify My Payment History Link and Logout from Application
		public void MyPaymentHistoryLink() throws InterruptedException, IOException
		{
			test = report.startTest(" My Payment History Link", "My Payment History and Logout from Application");
			tdweb.findElement(By.xpath(RegOR.getProperty("Payment"))).click();
			tdweb.findElement(By.xpath(RegOR.getProperty("Mypaymenthistory"))).click();
			test.log(LogStatus.INFO, " My Payment History  Link");
			UtilityRedirectingPage.pausing();// has been implemented to take screenshot for My Payment History link
			UtilityRedirectingPage.capturescreenshot(tdweb, " My Payment History");
			test.log(LogStatus.PASS, "Sucessfully clicked on  My Payment History");
			tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
			tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
			test.log(LogStatus.PASS, "User logout Sucessfully");
			report.endTest(test);
			report.flush();							
		}
		
	// Verify Help Link and Logout from Application
	public void HelpLink() throws InterruptedException, IOException
	{
		test = report.startTest("Help Link", "Verifying Help Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Help"))).click();
		test.log(LogStatus.INFO, " Help  Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Help link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Help");
		test.log(LogStatus.PASS, "Sucessfully clicked on Help Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();						
	}
	
	
	
	// Verify Invite Your Team Link and Logout from Application
	public void InviteYourTeamLink() throws InterruptedException, IOException
	{
		test = report.startTest("Invite Your Team Link", "Verifying Help Link and Logout from Application");
		tdweb.findElement(By.xpath(RegOR.getProperty("Inviteyourteam"))).click();
		test.log(LogStatus.INFO, " Invite Your Team Link");
		UtilityRedirectingPage.pausing();// has been implemented to take screenshot for Invite Your Team link
		UtilityRedirectingPage.capturescreenshot(tdweb, "Invite Your Team");
		test.log(LogStatus.PASS, "Sucessfully clicked on Invite Your Team Link");
		tdweb.findElement(By.cssSelector(RegOR.getProperty("CompanyLink"))).click();
		tdweb.findElement(By.cssSelector(RegOR.getProperty("Logout"))).click();
		test.log(LogStatus.PASS, "User logout Sucessfully");
		report.endTest(test);
		report.flush();								
	}
	
	
	
		
	
}


	

// Ending of Login Page 