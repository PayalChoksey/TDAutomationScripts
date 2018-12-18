package EditTimeCustomerBug;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//[Edit Time] New Edit Time Page doesn't fill the not working slot if we try to add a manual entry but it just adds a random hour
/* Project Name : Time Doctor Automation Framework 
* Author : Time Doctor QA Team
* Version : V 1.0 
* Reviewed By : Sandy
* Date of Creation : 10/15/2018
* Modification History : 
* Date of change : 10/15/2018 
* Version : V 1.1 
* changed function :  
* change description : Added all the standards and modified the code
* Modified By : Payal Choksey 
* By : Payal Choksey 
*/
public class TIME68 {
	public static Properties Config=null;
	public static Properties LoginOR=null;
	public static WebDriver tdweb = null;
	public static String browserName = "Chrome";
	public static String currentURL; 
	public static String verifyLogIn;
	public static Properties RegOR=null;
	ExtentTest test;
	ExtentReports report;
	
	// https://globalworkforce.jira.com/browse/TIME-62 : [New Edit time page] Some time entries are still duplicated
	
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
	public void TDLoginPage() throws InterruptedException, IOException
	{
		report = new ExtentReports(
				"/Users/payalchoksey/git/repository8/TDAutomationScript_5/src/test/resources/Reports/EditTimePage/TIME5.html", true);
		if(Config.getProperty("BrowserName").equals("Chrome"))
		{
			test = report.startTest("TD Login Page - In Chrome", "Opening the Application");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//Source//chromedriver");
			tdweb = new ChromeDriver();
			tdweb.get(Config.getProperty("LoginURL"));
			tdweb.manage().window().fullscreen();
			test.log(LogStatus.INFO, "Chrome Browser Launched Successfully");
			test.log(LogStatus.INFO, "Time Doctor Application Opened in Chrome - Login Page");
			test.log(LogStatus.PASS, "Application opened sucessfully in Chrome - Login Page");
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
	
	public void Time62customerbug()
	{
		tdweb.get("https://login.timedoctortest.com/#/dashboard-company");
		tdweb.findElement(By.cssSelector(".head-link > a[href^=\"/v2/index.php\"]")).click();
		tdweb.findElement(By.cssSelector(".td-view-switch > a.td-view-button:nth-of-type(1) > span > b")).click();
		tdweb.findElement(By.cssSelector("button.td-button")).click();
		String hour1 = tdweb.findElement(By.cssSelector("#td-bar-0 > .td-bar-inner > p > em")).getText();
		System.out.println(hour1);
		String hour2 = tdweb.findElement(By.cssSelector("#td-bar-0 > .td-bar-inner > p > em")).getText();
		System.out.println(hour2);
		
		if ( hour1 .equals(hour2))
		{
			System.out.println(" Correct hour is displayed");
		
		}
		else 
		{
			System.out.println(" Incorrect hours is displayed");
		}
	       // assertEquals(tdweb.findElement(By.cssSelector("#td-bar-0 > .td-bar-inner > p > em")).getText(), "1h");
	        assertEquals(tdweb.findElement(By.cssSelector(".time-length > span")).getText(), "1h");
	        tdweb.findElement(By.cssSelector("a.td-button.td-button-white.td-button-has-icon-cancel > span")).click();
	}

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
		test.log(LogStatus.PASS, "Screenshot captured after login with valid credentials");
		report.endTest(test);
		report.flush();
	}
}
