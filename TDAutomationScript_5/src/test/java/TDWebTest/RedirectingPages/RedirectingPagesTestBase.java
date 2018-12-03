package TDWebTest.RedirectingPages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class RedirectingPagesTestBase extends TDWeb_007_Combine{


	@BeforeTest
	public void propCalling() throws IOException
	{
		
		IntializingProperties();
	}
	
	@Parameters({"browser"})
	@Test(priority = 1)
	public void differentbrowser(String browser) throws IOException {
		
		
		if (browser.equals("Chrome"))
		{
			report = new ExtentReports(System.getProperty("user.dir")+"/src//test//resources//Reports//RedirectingPages//RedirectingPages1.html", true);
			test = report.startTest("TD Registration Page - In Chrome", "Opening the Application");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//Source//chromedriver");
			tdweb = new ChromeDriver();
			tdweb.manage().window().fullscreen();
			//test.log(LogStatus.INFO, "Chrome Browser Launched Successfully");
			tdweb.get(Config.getProperty("LoginURL"));
			UtilityRedirectingPage.capturescreenshot(tdweb, "ChromeApplication");
			test.log(LogStatus.INFO, "Time Doctor Application Opened in Chrome");
			test.log(LogStatus.PASS, "Application opened sucessfully in Chrome");
			report.endTest(test);
			report.flush();
		}
		else if(browser.equals("Firefox"))
		{	
			report = new ExtentReports(System.getProperty("user.dir")+"/src//test//resources//Reports//RedirectingPages//RedirectingPages2.html", true);
			test = report.startTest("TD Registration Page - In FireFox", "Opening the Application");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//Source//geckodriver");
			tdweb = new FirefoxDriver();
			tdweb.manage().window().fullscreen();
			tdweb.get(Config.getProperty("LoginURL"));
			UtilityRedirectingPage.capturescreenshot(tdweb, "FirefoxApplication");
			test.log(LogStatus.INFO, "Time Doctor Application Opened in Firefox");
			test.log(LogStatus.PASS, "Application opened sucessfully in Firefox");
			report.endTest(test);
			report.flush();
		}
		else 
		{
			System.out.println(" Browser is not found!!");
		}
	}		
	@Test(priority = 2)
	public void credentials() throws InterruptedException, IOException
	{
		ValidCredentials();
	}
	
	@Test(priority = 3)
	public void Client() throws InterruptedException, IOException
	{
		ClientsLink();
		ValidCredentials();
	}
	
	@Test(priority = 3)
	public void ProjectNPermanentTask() throws InterruptedException, IOException
	{
		ProjectPermanentTaskLink();
		ValidCredentials();
		
	}
	
	@Test(priority = 4)
	public void UserSetting() throws InterruptedException, IOException
	{
		UserSettingLink();
		ValidCredentials();
		
	}
	

	@Test(priority = 5)
	public void ManageUsers() throws InterruptedException, IOException
	{
		ManageUserLink();
		ValidCredentials();
		
	}
	

	@Test(priority = 6)
	public void Payroll() throws InterruptedException, IOException
	{
		PayrollSettingLink();
		ValidCredentials();
		
	}
	
	@Test(priority = 7)
	public void Payoneer() throws InterruptedException, IOException
	{
		PayoneerSettingLink();
		ValidCredentials();
		
	}
	
	@Test(priority = 8)
	public void WorkSchedule() throws InterruptedException, IOException
	{
		WorkScheduleLink();
		ValidCredentials();
		
	}
	
	@Test(priority = 9)
	public void Integration() throws InterruptedException, IOException
	{
		IntegrationLink();
		ValidCredentials();
		
	}
	
	@Test(priority = 10)
	public void CompanyIntegration() throws InterruptedException, IOException
	{
		CompanyIntegrationLink();
		ValidCredentials();
		
	}
	
	@Test(priority = 11)
	public void API() throws InterruptedException, IOException
	{
		APILink();
		ValidCredentials();
		
	}
	

	@Test(priority = 12)
	public void BilingLink() throws InterruptedException, IOException
	{
		BillingLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 13)
	public void Dashboard() throws InterruptedException, IOException
	{
		DashboardLink();
		ValidCredentials();
		
	} 
	@Test(priority = 13)
	public void Edit() throws InterruptedException, IOException
	{
		EditTimeLink();
		ValidCredentials();
		
	} 
	@Test(priority = 14)
	public void Screenshot() throws InterruptedException, IOException
	{
		ScreenshotLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 15)
	public void Timesheet() throws InterruptedException, IOException
	{
		TimeSheetLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 16)
	public void Timeuse() throws InterruptedException, IOException
	{
		TimeUseLink();
		ValidCredentials();
		
	} 
	@Test(priority = 17)
	public void Timeline() throws InterruptedException, IOException
	{
		TimeLineLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 18)
	public void Poortimeuse() throws InterruptedException, IOException
	{
		PoorTimeUseLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 19)
	public void Webapp() throws InterruptedException, IOException
	{
		WebAppLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 20)
	public void Projects() throws InterruptedException, IOException
	{
		ProjectsLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 21)
	public void Attendance() throws InterruptedException, IOException
	{
		AttendanceLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 22)
	public void GPS() throws InterruptedException, IOException
	{
		GPSLink();
		ValidCredentials();
		
	}
	
	@Test(priority = 23)
	public void Currentpayroll() throws InterruptedException, IOException
	{
		CurrentPayrollLink();
		ValidCredentials();
		
	} 

	@Test(priority = 24)
	public void PayrollHistory() throws InterruptedException, IOException
	{
		PayrollHistoryLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 25)
	public void EditAbsent() throws InterruptedException, IOException
	{
		EditAbsentLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 26)
	public void ReviewManualTime() throws InterruptedException, IOException
	{
		ReviewManualTimeLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 27)
	public void RequestPaymentClient() throws InterruptedException, IOException
	{
		RequestPaymentClientLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 28)
	public void SendPayment() throws InterruptedException, IOException
	{
		SendPaymentLink();
		ValidCredentials();
		
	} 
	@Test(priority = 29)
	public void RequestPaymentList() throws InterruptedException, IOException
	{
		RequestPaymentListLink();
		ValidCredentials();
		
	} 
	@Test(priority = 30)
	public void RequestPaymentHistory() throws InterruptedException, IOException
	{
		RequestPaymentHistoryLink();
		ValidCredentials();
		
	} 
	@Test(priority = 31)
	public void MyPaymentHistory() throws InterruptedException, IOException
	{
		MyPaymentHistoryLink();
		ValidCredentials();
		
	} 
	
	@Test(priority = 32)
	public void Help() throws InterruptedException, IOException
	{
		HelpLink();
		ValidCredentials();
		
	} 
	
	
	
	@Test(priority = 33)
	public void InviteYourTeam() throws InterruptedException, IOException
	{
		InviteYourTeamLink();
		ValidCredentials();
		
	} 
	
	
	@AfterTest
	public void logout() throws InterruptedException, IOException
	{
		tdweb.close();
		tdweb.quit();
		
	}

}



	


