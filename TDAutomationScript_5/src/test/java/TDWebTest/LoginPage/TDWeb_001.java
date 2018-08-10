package TDWebTest.LoginPage;

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
import org.testng.Assert;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TDWeb_001 {
	public static Properties CONFIG=null;
	public static Properties LoginOR=null;
	public static WebDriver driver = null;
	public static String browser = "Chrome";
	public static String currentURL;
	public static String verifyLogIn;
	public ExtentTest test;
	
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	 // create ExtentReports and attach reporter(s)
	ExtentReports extent = new ExtentReports();
	// Properties file for each page for TD
	public void intializing() throws IOException
	{
		CONFIG= new Properties();
		FileInputStream config =new FileInputStream(System.getProperty("user.dir")+"/src//test//resources//Source//Config.properties");
		CONFIG.load(config);
		LoginOR= new Properties();
		FileInputStream loginor =new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Source//LoginPage.properties");
		LoginOR.load(loginor);
	}
	
	// Calling the application in various browser
	public void TDLogin() throws InterruptedException, IOException
	{
		if(CONFIG.getProperty("Browser").equals("Chrome"))
		{
			extent.attachReporter(htmlReporter);
			test = extent.createTest("TD Login Page", "Opening the Application");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//Source//chromedriver");
			driver = new ChromeDriver();
			test.log(Status.INFO, "Chrome Browser Launched Successfully");
			driver.get(CONFIG.getProperty("LoginURL"));
			test.log(Status.INFO, "Time Doctor Application Opened");
			test.log(Status.PASS, "Application opened sucessfully");
			extent.flush();
		}else if(CONFIG.getProperty("Browser").equals("Firefox")){
			System.out.println(" Fire fox work pending");
		}
		else if(CONFIG.getProperty("Browser").equals("Safari")){
			System.out.println(" Safari work pending");
		}
		test = extent.createTest("TD Title Of Page", "Verifying the Title of the Page");
		String actual = driver.getTitle();
		test.log(Status.INFO, "Actual Title returned :: " + actual);
		String expected = "Login to Time Doctor";
		test.log(Status.INFO, "Expected Title returned:: "+ expected);
		Assert.assertEquals(actual,expected);
		test.log(Status.PASS, "Title of the Page is correct");	
		driver.manage().window().fullscreen();
		Thread.sleep(3000L);
		extent.attachReporter(htmlReporter);
		test = extent.createTest("TD Title Of Page1", "Verifying the Title of the Page1");
		driver.findElement(By.xpath(LoginOR.getProperty("Email"))).sendKeys("payal+30test@staff.com");
		driver.findElement(By.xpath(LoginOR.getProperty("Password"))).sendKeys("payal123");
		driver.findElement(By.xpath(LoginOR.getProperty("Signinbtn"))).click();
		test.log(Status.INFO, "Entering the valid credentials");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		currentURL=driver.getCurrentUrl();
			if(currentURL.equals(CONFIG.getProperty("DashboardURL")))
			{
				test.log(Status.PASS, "Allowed to accept valid credentials");	
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/vloginpage.jpg"));// copies the image that is bytes to .jpg
				test.log(Status.INFO, "Screenshot captured after login");

			}
			else
			{
			//	test.log(Status.FAIL, "Incorrect Credentials Entered");	
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/inloginpage.jpg"));	
			}
			extent.flush();
		}
}	