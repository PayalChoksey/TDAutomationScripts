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
package TDWebTest.RegistrationPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

import TDWebTest.LoginPage.TDWeb_001;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TDWeb_004 extends TDWeb_001 {
	public static Properties Config=null;
	public static Properties LoginOR=null;
	public static WebDriver driver = null;
	public static String browserName = "Chrome";
	public static String currentURL; 
	public static String verifyLogIn;
	public static Properties RegOR=null;
	ExtentTest test;
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
	
	public void TDRegistrationPage() throws InterruptedException, IOException
	{
		report = new ExtentReports(
				"/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/Reports/TDRegistrationReport.html", true);
		if(Config.getProperty("BrowserName").equals("Chrome"))
		{
			test = report.startTest("TD Registration Page - In Chrome", "Opening the Application");
			
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//Source//chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
			test.log(LogStatus.INFO, "Chrome Browser Launched Successfully");
		
			driver.get(Config.getProperty("RegistrationURL"));
			driver.findElement(By.id("question1")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Do you manage other people?'])[1]/following::button[1]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The average time wasted is 2.09 hours daily'])[1]/following::button[1]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='To see exactly where your time goes each day.'])[1]/following::button[1]")).click();
			  
			test.log(LogStatus.INFO, "Time Doctor Application Opened in Chrome");
			test.log(LogStatus.PASS, "Application opened sucessfully in Chrome");
			report.endTest(test);
			report.flush();
		}
		else if(Config.getProperty("BrowserName").equals("Firefox"))
		{
			System.out.println(" Firefox to be implemented");
		}
		else if(Config.getProperty("BrowserName").equals("Safari"))
		{

			System.out.println(" Safari to be implemented");
			
		}
	}
		// Verifying the Title of the page displayed
	public void VerifyTitle() throws InterruptedException, IOException
		{
			
		test = report.startTest("TD Title of Page", "Verifying the Title of the Page");
		String actualTitle = driver.getTitle();
		test.log(LogStatus.INFO, "Actual Title of Page returned :: " + actualTitle);
		String expectedTitle = "Smart Employee Time Tracking Software with Screenshots | Time Doctor";
		test.log(LogStatus.INFO, "Expected Title of Page returned :: "+ expectedTitle);
		Assert.assertEquals(actualTitle,expectedTitle);
		test.log(LogStatus.PASS, "Title of the Page is valid");	
		driver.manage().window().fullscreen();
		Thread.sleep(3000L);
		report.endTest(test);
		report.flush();
		}
	// Entering the valid credentials on Registration Page
	public void RegistrationDetails (String name, String email, String password) throws InterruptedException, IOException
	
		{
		
		String registrationType = "InviteTeam";
		
		
		  if (registrationType.equals("TestmySelf"))
		  {	
			  	test = report.startTest("TD Registration Page", "Entering the details on Registration Page");
			  	test.log(LogStatus.INFO, "Testing for Test My Self Option");
				driver.findElement(By.id(RegOR.getProperty("Self"))).click();
			    driver.findElement(By.id(RegOR.getProperty("Continue"))).click();
			    driver.findElement(By.id(RegOR.getProperty("Name"))).clear();
			    driver.findElement(By.id(RegOR.getProperty("Name"))).sendKeys(name);
			    test.log(LogStatus.INFO, "Entered the name as  :: " + name);
			    driver.findElement(By.id(RegOR.getProperty("Email"))).clear();
			    driver.findElement(By.id(RegOR.getProperty("Email"))).sendKeys(email);
			    test.log(LogStatus.INFO, "Entered the email as  :: " + email);
			    driver.findElement(By.id(RegOR.getProperty("Password"))).clear();
			    driver.findElement(By.id(RegOR.getProperty("Password"))).sendKeys(password);
			    test.log(LogStatus.INFO, "Entered the password as  :: " + password);
			    driver.findElement(By.id(RegOR.getProperty("GetStarted"))).click();
			    Thread.sleep(5000L);
			    test.log(LogStatus.PASS, "Details are entered");
			    report.endTest(test);
		   		report.flush();
			  
			    
			    currentURL=driver.getCurrentUrl();
			    if (currentURL.equals("https://www.timedoctortest.com/"))
			    {
			    	test = report.startTest("TD DashBoard URL", "Checking the Dashboard URL is opened correctly ");
			    	test.log(LogStatus.FAIL, "User has entered invalid details");	
			    	test.log(LogStatus.FAIL, " User is unable to navigate to Dashboard Page - Wrong data entered");	
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/inregistrationpage.jpg"));// copies the image that is bytes to .jpg
					test.log(LogStatus.INFO, "Screenshot captured after user entering invalid data");
					report.endTest(test);
			   		report.flush();
					
			    	
			    }
			    else if (currentURL.equals("https://login.timedoctortest.com/#/dashboard-company"))
			    {
			    	test = report.startTest("TD DashBoard URL", "Checking the Dashboard URL is opened correctly ");
			    	test.log(LogStatus.PASS, "User has entered valid details");	
			    	test.log(LogStatus.PASS, "Dashboard page has opened successfully");	
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/vregistrationpage.jpg"));// copies the image that is bytes to .jpg
					test.log(LogStatus.INFO, "Screenshot captured after user entering invalid data");
			    	System.out.println("User has entered the correct details");
			    	report.endTest(test);
			   		report.flush();
			    	
			    }
			    else
			    {
			    	test = report.startTest("TD DashBoard URL", "Checking the Dashboard URL is opened correctly ");
			    	test.log(LogStatus.FAIL, "Please check the connectivity");	
			    	test.log(LogStatus.INFO, "OOPS!! please check your connectivity");
			    	System.out.println("Please check you connectivity");
			    	report.endTest(test);
			   		report.flush();
			    	
			    }
		  }
			    
			    else if (registrationType.equals("InviteTeam"))
			    {
			    	test = report.startTest("TD Registration Page", "Entering the details on Registration Page");
				  	test.log(LogStatus.INFO, "Testing for Invite Team");
			    	driver.findElement(By.xpath(RegOR.getProperty("MyTeam"))).click();
				    driver.findElement(By.id(RegOR.getProperty("Continue"))).click();
				    driver.findElement(By.id(RegOR.getProperty("Name"))).clear();
				    driver.findElement(By.id(RegOR.getProperty("Name"))).sendKeys(name);
				    test.log(LogStatus.INFO, "Entered the name as  :: " + name);
				    driver.findElement(By.id(RegOR.getProperty("Email"))).clear();
				    driver.findElement(By.id(RegOR.getProperty("Email"))).sendKeys(email);
				    test.log(LogStatus.INFO, "Entered the email as  :: " + email);
				    driver.findElement(By.id(RegOR.getProperty("Password"))).clear();
				    driver.findElement(By.id(RegOR.getProperty("Password"))).sendKeys(password);
				    test.log(LogStatus.INFO, "Entered the password as  :: " + password);
				    driver.findElement(By.id(RegOR.getProperty("GetStarted"))).click();
				    Thread.sleep(5000L);
				    test.log(LogStatus.PASS, "Details are entered");
				    report.endTest(test);
			   		report.flush();
				    
				    currentURL=driver.getCurrentUrl();
				    if (currentURL.equals("https://www.timedoctortest.com/"))
				    {
				    	test = report.startTest("TD Registration Page", "Entering the details on Registration Page");
					  	test.log(LogStatus.FAIL, "Invalid Registration information are entered");
				    	System.out.println("Enter the valid credentials");
				    	report.endTest(test);
				   		report.flush();
				    }
				    else if (currentURL.equals("https://login.timedoctortest.com/#/dashboard-company"))
				    {
				    	test = report.startTest("TD Registration Page", "Entering the details on Registration Page");
					  	test.log(LogStatus.PASS, "Valid Resitration Details are entered");
					  	test.log(LogStatus.PASS, "Correct Dashboard page is opened" +currentURL);
				    	System.out.println("You have entered the correct URL");
				    	report.endTest(test);
				   		report.flush();
				    }
				    else
				    {
				    	System.out.println("Please check you connectivity");
				    }
			    }
			    else
			    {
			    	test = report.startTest("TD Registration Page", "Entering the details on Registration Page");
			    	 test.log(LogStatus.FAIL, "No such Registration found");
			    	System.out.println("No such resgistration process found");
			    	report.endTest(test);
			   		report.flush();
			    }
		
			
			
		}
}
	
		

// Ending of Login Page 