package TDWebTest.LoginPage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTestBase extends TDWeb_001{
	ExtentReports report;
	ExtentTest logger;
		@BeforeTest
		public void browser() throws IOException
		{
			
			intializing();
		}
		@Test (priority = 1)
		public void login() throws IOException, InterruptedException
		{
			TDLogin();
			 	// driver.findElement(By.cssSelector("td-navigation-bar__company-name")).click(); 
				//    driver.findElement(By.cssSelector("a[href=\"/apps/manage-users\"] > span")).click();
		}
		
	
	}



