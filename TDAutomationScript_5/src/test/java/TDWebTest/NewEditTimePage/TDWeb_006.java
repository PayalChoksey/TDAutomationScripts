package TDWebTest.NewEditTimePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class TDWeb_006 {
	public static Properties Config=null;
	public static Properties LoginOR=null;
	ExtentTest test;
	ExtentReports report;
	public WebDriver tdweb = null;
	public static String currentURL; 
	public static String verifyLogIn;
	
	// Intializing the Properties
	public void IntializingProperties() throws IOException
	{
		Config= new Properties();
		FileInputStream config =new FileInputStream(System.getProperty("user.dir")+"/src//test//resources//Source//Config.properties");
		Config.load(config);
		LoginOR= new Properties();
		FileInputStream loginor =new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Source//LoginPage.properties");
		LoginOR.load(loginor);
	}
	
	
	public void LaunchApp(String browser) throws IOException
	{
		if (browser.equals("Chrome"))
		{
			report = new ExtentReports(System.getProperty("user.dir")+"/src//test//resources//Reports//EditTimePage//EditTimePage.html", true);
			test = report.startTest("TD Registration Page - In Chrome", "Opening the Application");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//Source//chromedriver");
			tdweb = new ChromeDriver();
			tdweb.manage().window().fullscreen();
			test.log(LogStatus.INFO, "Chrome Browser Launched Successfully");
			UtilityNewEditTimePage.capturescreenshot(tdweb, "BrowserLaunched");
			tdweb.get(Config.getProperty("LoginURL"));
			UtilityNewEditTimePage.capturescreenshot(tdweb, "ChromeApplication");
			test.log(LogStatus.INFO, "Time Doctor Application Opened in Chrome");
			test.log(LogStatus.PASS, "Application opened sucessfully in Chrome");
			report.endTest(test);
			report.flush();
		}
		else if(browser.equals("Firefox"))
		{	
			report = new ExtentReports(System.getProperty("user.dir")+"/src//test//resources//Reports//EditTimePage//EditTimePage1.html", true);
			test = report.startTest("TD Registration Page - In FireFox", "Opening the Application");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//Source//geckodriver");
			tdweb = new FirefoxDriver();
			UtilityNewEditTimePage.capturescreenshot(tdweb, "BrowserLaunched");
			tdweb.manage().window().fullscreen();
			tdweb.get(Config.getProperty("LoginURL"));
			UtilityNewEditTimePage.capturescreenshot(tdweb, "FirefoxApplication");
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
	// Login with credentials
		public void login(String email, String password) throws IOException
		{
			test = report.startTest("Time Doctor Login Page - Normal Login ", "Login");
			test.log(LogStatus.INFO, "Login Page - Login"); 
			tdweb.findElement(By.cssSelector("#email")).sendKeys(email);
			test.log(LogStatus.INFO, "Enter valid email address");
			tdweb.findElement(By.cssSelector("#password")).sendKeys(password);
			test.log(LogStatus.INFO, "Enter valid password");
			tdweb.findElement(By.cssSelector("#password")).sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Login sucessfully");
			UtilityNewEditTimePage.capturescreenshot(tdweb, "Login");
			test.log(LogStatus.PASS, "Screenshot captured after login with valid credentials");
			report.endTest(test);
			report.flush();
		}
		// Navigating to the Edit Time Page
		public void editnavigation() throws IOException
		{
			test = report.startTest("Navigating to Edit Time Page from Left Navigation bar ", "Edit Time Page");
			test.log(LogStatus.INFO, "Navigating to Edit Time Page from Left Navigation bar"); 
			UtilityNewEditTimePage.capturescreenshot(tdweb, "EditTimePage");
			tdweb.findElement(By.xpath("//*[@id='mCSB_1_container']/ul[2]/li[2]/a")).click();
			currentURL=tdweb.getCurrentUrl();
			System.out.println(currentURL);
			if(currentURL.equals(Config.getProperty("EditURL")))
				{
				test.log(LogStatus.FAIL, "Edit Time Page Error");	
				
					test.log(LogStatus.INFO, "Screenshot captured for Edit Time Page");

				}
			else
				{
				UtilityNewEditTimePage.capturescreenshot(tdweb, "CorrectEditTimePageOpened");
				test.log(LogStatus.PASS, "Edit Time Page has Sucessfully Opened");	
				test.log(LogStatus.INFO, "Screenshot captured for Edit Time Page");
					
				}
			report.endTest(test);
			report.flush();
		}
		
		// Drop list on number of user,admin or manager
		public void droplistuser() throws IOException
		{
			test = report.startTest("Verification of current user selected in drop down with Login User", "Current User selected with Login User");
			
			test.log(LogStatus.INFO, "Current user selected in drop down with Login User"); 
			assertTrue((tdweb.findElements(By.cssSelector("#users-select-container > .btn-group > button[type=\"button\"].dropdown-toggle.btn")).size() != 0));
			tdweb.findElement(By.cssSelector("#users-select-container > .btn-group > button[type=\"button\"].dropdown-toggle.btn > b.caret")).click();
	        assertTrue((tdweb.findElements(By.cssSelector("label.radio")).size() != 0));
	        tdweb.findElement(By.cssSelector("#users-select-container > .btn-group > button[type=\"button\"].dropdown-toggle.btn > b.caret")).click();
	        UtilityNewEditTimePage.capturescreenshot(tdweb, "UserSelected");
	        test.log(LogStatus.PASS, "Current user selected in drop down with Login User"); 
	        report.endTest(test);
			report.flush();
	     
	    }
		
		//Verifying Cancel Button
		public void AddtimeCancel() throws InterruptedException, IOException
		{
			test = report.startTest("Verification of Cancel button on Add Time popup", "Add Time - Cancel Button");
			tdweb.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div[2]/button")).click();
			Thread.sleep(2000L);
			test.log(LogStatus.INFO, "Clicking on Cancel button"); 
			tdweb.findElement(By.cssSelector("a.td-button.td-button-white.td-button-has-icon-cancel > span")).click();	
			UtilityNewEditTimePage.capturescreenshot(tdweb, "CancelButton");
			test.log(LogStatus.PASS, "Addtime has been cancelled sucessfully"); 
			report.endTest(test);
			report.flush();
			
		}
		
		// Verifying the Save button with no data
		public void InvalidProjectName() throws InterruptedException, IOException
		{
			test = report.startTest("Verification of Save button on Add Time popup", "Add Time - Save Button without entering any data");
			tdweb.findElement(By.cssSelector("button.td-button")).click();
			test.log(LogStatus.INFO, "Clicking on Save button"); 
			Thread.sleep(2000L);
			tdweb.findElement(By.cssSelector(".row > div:nth-of-type(1) > a.td-button.pull-right.td-button-has-icon-save")).click();
			String time = tdweb.findElement(By.cssSelector(".td-alert")).getText();
			System.out.println(time);
				if (time.equals("Please enter Project Name."))
				{
					UtilityNewEditTimePage.capturescreenshot(tdweb, "InvalidProjectName");
					System.out.println("Correct Validation message is displayed");
				}
	      
				else
				{
					System.out.println("Incorrect Validation message is displayed");
				}
			
			
				tdweb.findElement(By.cssSelector("a.td-button.td-button-white.td-button-has-icon-cancel > span")).click();
				report.endTest(test);
				report.flush();

		}
		
		
		// Verifying the Save button with no data
				public void InvalidTaskName() throws InterruptedException, IOException
				{
					test = report.startTest("Verification of Save button on Add Time popup", "Add Time - Save Button without entering any data");
					tdweb.findElement(By.cssSelector("button.td-button")).click();
					test.log(LogStatus.INFO, "Clicking on Save button"); 
					Thread.sleep(2000L);
					tdweb.findElement(By.cssSelector("#td-task-dropdown-input")).click();
					String time = tdweb.findElement(By.cssSelector(".td-alert")).getText();
					System.out.println(time);
						if (time.equals("Please enter a task name."))
						{
							UtilityNewEditTimePage.capturescreenshot(tdweb, "InvalidTaskName");
							System.out.println("Correct Validation message is displayed");
						}
			      
						else
						{
							System.out.println("Incorrect Validation message is displayed");
						}
					
					
						tdweb.findElement(By.cssSelector("a.td-button.td-button-white.td-button-has-icon-cancel > span")).click();
						report.endTest(test);
						report.flush();

				}
				
		
		
		//Entering wrong project name
		public void InvalidDataProjectName() throws InterruptedException, IOException
		{
			test = report.startTest("Entering wrong Project Name", "Add Time - Wrong project name validation");
			tdweb.findElement(By.cssSelector("button.td-button")).click();
			test.log(LogStatus.INFO, "Verfying the wrong project name"); 
			tdweb.findElement(By.xpath("//*[@id='content-container']/div/div[1]/div[2]/div[2]/button"));
			Thread.sleep(2000L);

			tdweb.findElement(By.cssSelector("#td-project-dropdown-input")).sendKeys("j");
			UtilityNewEditTimePage.capturescreenshot(tdweb, "ProjectNameInvalid");
			tdweb.findElement(By.cssSelector(".row > div:nth-of-type(1) > a.td-button.pull-right.td-button-has-icon-save")).click();
		    assertEquals(tdweb.findElement(By.cssSelector(".task-details-scroll > .form-group:nth-of-type(1) > .td-alert")).getText(), "You can only add new projects in Projects and Permanent tasks, choose one from the list.");
		    test.log(LogStatus.PASS, "Correct validation message is displayed after entering wrong project name"); 
		    tdweb.findElement(By.cssSelector("a.td-button.td-button-white.td-button-has-icon-cancel > span")).click();		
			report.endTest(test);
			report.flush();
		}
		
		// Entering all details for Manual Edit Time Correctly
		public void manualedittime() throws InterruptedException, IOException
		{
			test = report.startTest("Manual Edit time", "Add Time - Entering Valid Data");
			tdweb.findElement(By.cssSelector("button.td-button")).click();
			Thread.sleep(5000L);
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).click();
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).click();
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).clear();
			
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).sendKeys("new test");
			 test.log(LogStatus.PASS, "Task Name has been entered correctly"); 
			tdweb.findElement(By.cssSelector(".form-group > div:nth-of-type(1) > input[type=\"text\"].form-control.ui-timepicker-input")).click();
			tdweb.findElement(By.cssSelector(".ui-timepicker-list > .ui-timepicker-am:nth-of-type(2)")).click();
			tdweb.findElement(By.cssSelector(".form-group > div:nth-of-type(3) > input[type=\"text\"].form-control.ui-timepicker-input")).click();
			tdweb.findElement(By.cssSelector(".form-group > .ui-timepicker-wrapper:nth-of-type(7) > .ui-timepicker-list > .ui-timepicker-am:nth-of-type(4)")).click();
			tdweb.findElement(By.cssSelector(".task-details-scroll > .form-group:nth-of-type(5) > textarea.form-control")).click();
			tdweb.findElement(By.cssSelector(".task-details-scroll > .form-group:nth-of-type(5) > textarea.form-control")).click();
			tdweb.findElement(By.cssSelector(".task-details-scroll > .form-group:nth-of-type(5) > textarea.form-control")).clear();
			tdweb.findElement(By.cssSelector(".task-details-scroll > .form-group:nth-of-type(5) > textarea.form-control")).sendKeys("reason");
			tdweb.findElement(By.xpath("//*[@id=\"td-project-dropdown-input\"]")).sendKeys("Project");
			UtilityNewEditTimePage.capturescreenshot(tdweb, "ManualTimeEntry");
			tdweb.findElement(By.cssSelector(".row > div:nth-of-type(1) > a.td-button.pull-right.td-button-has-icon-save")).click();
			test.log(LogStatus.PASS, "Sucessfully entered the manual time");
			report.endTest(test);
			report.flush();

		}
		
		// Verifying the date button
		public void datebutton() throws IOException
		{
			test = report.startTest("Date", "Selecting the date");
			tdweb.findElement(By.cssSelector(".btn-group.date-range-item.pull-right.dcal > button[type=\"button\"].btn.tdBtn.tdBtnPrev.btn-default > .btnPrevious")).click();
			tdweb.findElement(By.cssSelector(".btn-group.date-range-item.pull-right.dcal > button[type=\"button\"].btn.tdBtn.tdBtnNext.btn-default")).click();
			tdweb.findElement(By.cssSelector(".btn-group.date-range-item.pull-right.dcal > button[type=\"button\"].btn.tdBtn.tdBtnPrev.btn-default")).click();
			tdweb.findElement(By.cssSelector(".btn-group.date-range-item.pull-right.dcal > button[type=\"button\"].btn.tdBtn.tdBtnNext.btn-default")).click();
			tdweb.findElement(By.cssSelector(".btn-group.date-range-item.pull-right.dcal > button[type=\"button\"].btn.tdBtn.tdBtnNext.btn-default")).click();
			tdweb.findElement(By.cssSelector(".btn-group.date-range-item.pull-right.dcal > button[type=\"button\"].btn.tdBtn.tdBtnPrev.btn-default > .btnPrevious")).click();
			UtilityNewEditTimePage.capturescreenshot(tdweb, "Date");
			test.log(LogStatus.PASS, "Sucessfully selected the date");
			report.endTest(test);
			report.flush();
		}
		
		//Verifying  List view
		public void TimeLineView() throws InterruptedException, IOException
		{
			test = report.startTest("Time Line View", "Clicking on List View");
			Thread.sleep(2000L);
			tdweb.findElement(By.xpath("//*[@id=\"edit-time-view-switch\"]/div/a[1]/span/b")).click();
			
			tdweb.findElement(By.cssSelector("button.td-button")).click();
			Thread.sleep(2000L);
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).click();
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).click();
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).clear();
			tdweb.findElement(By.cssSelector(".form-group.td-type-ahead > input[type=\"text\"].form-control")).sendKeys("Task Name");
			tdweb.findElement(By.xpath("//*[@id=\"td-project-dropdown-input\"]")).sendKeys("Project");
			tdweb.findElement(By.cssSelector(".row > div:nth-of-type(1) > a.td-button.pull-right.td-button-has-icon-save")).click();
		
		
			UtilityNewEditTimePage.capturescreenshot(tdweb, "TimeLine");
			test.log(LogStatus.PASS, "Sucessfully selecting the list view");
			report.endTest(test);
			report.flush();
			Thread.sleep(5000L);
			tdweb.close();
		}
	
		
	}

