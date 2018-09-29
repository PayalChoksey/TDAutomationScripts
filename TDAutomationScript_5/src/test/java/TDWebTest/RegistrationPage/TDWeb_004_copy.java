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
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TDWeb_004_copy {
	public static Properties Config=null;
	public static Properties LoginOR=null;
	public static WebDriver driver = null;
	public static String browserName = "Chrome";
	public static String currentURL;
	public static String verifyLogIn;
	public ExtentTest testReport;
	public static Properties RegOR=null;
	
	
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/Reports/TDLoginPageReports.html");
	ExtentReports extentRep = new ExtentReports();
	
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
		if(Config.getProperty("BrowserName").equals("Chrome"))
		{
			extentRep.attachReporter(htmlReporter);
			testReport = extentRep.createTest("TD Registration Page - In Chrome", "Opening the Application");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//Source//chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
			testReport.log(Status.INFO, "Chrome Browser Launched Successfully");
			driver.get(Config.getProperty("RegistrationURL"));
			driver.findElement(By.id("question1")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Do you manage other people?'])[1]/following::button[1]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='The average time wasted is 2.09 hours daily'])[1]/following::button[1]")).click();
			driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='To see exactly where your time goes each day.'])[1]/following::button[1]")).click();
			  
			testReport.log(Status.INFO, "Time Doctor Application Opened in Chrome");
			testReport.log(Status.PASS, "Application opened sucessfully in Chrome");
			extentRep.flush();
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
			
		testReport = extentRep.createTest("TD Title of Page", "Verifying the Title of the Page");
		String actualTitle = driver.getTitle();
		testReport.log(Status.INFO, "Actual Title of Page returned :: " + actualTitle);
		String expectedTitle = "Smart Employee Time Tracking Software with Screenshots | Time Doctor";
		testReport.log(Status.INFO, "Expected Title of Page returned :: "+ expectedTitle);
		Assert.assertEquals(actualTitle,expectedTitle);
		testReport.log(Status.PASS, "Title of the Page is valid");	
		driver.manage().window().fullscreen();
		Thread.sleep(3000L);
		extentRep.attachReporter(htmlReporter);
		}
	// Entering the valid credentials on Registration Page
	//	public void RegistrationDetails(String name,String email,String password) 
	public void RegistrationDetails() throws IOException
		{
			if(RegOR.getProperty("Registration").equals("TestmySelf"))
			{
				testReport = extentRep.createTest("TD Valid Login", "Entering with Valid Data on Test it myself");
				driver.findElement(By.id(RegOR.getProperty("Self"))).click();
			    driver.findElement(By.id(RegOR.getProperty("Continue"))).click();
			    driver.findElement(By.id(RegOR.getProperty("Name"))).clear();
			    driver.findElement(By.id(RegOR.getProperty("Name"))).sendKeys("name");
			    driver.findElement(By.id(RegOR.getProperty("Email"))).clear();
			    driver.findElement(By.id(RegOR.getProperty("Email"))).sendKeys("payal+62test@staff.com");
			    driver.findElement(By.id(RegOR.getProperty("Password"))).clear();
			    driver.findElement(By.id(RegOR.getProperty("Password"))).sendKeys("testtest");
			    driver.findElement(By.id(RegOR.getProperty("GetStarted"))).click();
			    if(currentURL.equals(RegOR.getProperty("DashboardURL")))
				{
					testReport.log(Status.PASS, "Allowed to Register with valid details");	
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/vRegistrationPage.jpg"));// copies the image that is bytes to .jpg
					testReport.log(Status.INFO, "Screenshot captured after login with valid credentials");

				}
			    else
				{
			    	testReport.log(Status.FAIL, "Incorrect Credentials Entered");	
			    	System.out.println("Incorrect Details are entered");
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/inRegistrationPage.jpg"));	
				}
			}
			else if (RegOR.getProperty("Registration").equals("InvitemyTeam"))
			{
				testReport = extentRep.createTest("TD Valid Login", "Entering with Valid Data");
				driver.findElement(By.id("self")).click();
			    driver.findElement(By.id("continue")).click();
			    driver.findElement(By.id("nameField")).clear();
			    driver.findElement(By.id("nameField")).sendKeys("payal");
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("payal+64test@staff.com");
			    driver.findElement(By.id("password")).clear();
			    driver.findElement(By.id("password")).sendKeys("testtest");
			    driver.findElement(By.id("getStarted")).click();
			}
			else
			{
				System.out.println(" Select the proper option");
		
		extentRep.flush();
		}
	
		}
}
// Ending of Login Page 