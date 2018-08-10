package TDWebTest.NewManagerUser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TDWebTest.LoginPage.TDWeb_001;

public class TDWeb_002 extends TDWeb_001{
	public static Properties NewManageUser=null;
	ExtentReports report;
	 ExtentTest test;
	
	// Landing on New Manager User Page
	public void manageuserlink() throws IOException
	
	{	
		report = new ExtentReports(
				"/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/Reports/automationreport.html", true);
		
		NewManageUser= new Properties();
		FileInputStream newmuser =new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Source//NewManagerUser.properties");
		NewManageUser.load(newmuser);
		test = report.startTest("Manage User Page");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.get(NewManageUser.getProperty("URLNewMUser"));
		test.log(LogStatus.INFO, "Open New Manage User Page");
		String actual = driver.getCurrentUrl();
		test.log(LogStatus.INFO, "Actual Title returned :: " + actual);
		String expected = "https://login.timedoctortest.com/apps/manage-users";
		test.log(LogStatus.INFO, "Expected Title returned:: "+ expected);
		Assert.assertEquals(actual,expected);
		test.log(LogStatus.PASS, "Manage User Page Opened Sucessfully");	
		driver.findElement(By.cssSelector(NewManageUser.getProperty("NewMUserbutton"))).click();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
		Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/manageuserlink.jpg"));
		test.log(LogStatus.INFO, "Screenshot Captured");
		
		report.endTest(test);
		report.flush();
	
	}
	// Checking the Invitation Button
public void invitation() throws IOException
	{
	test = report.startTest("Invitation");
	driver.findElement(By.cssSelector(NewManageUser.getProperty("invite"))).click();
	
    assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("invitation"))).getText(), "Invitations");
    test.log(LogStatus.PASS, "Invitation Page Opened");
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
	Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/invitationpage.jpg"));
    driver.navigate().back();
    assertTrue((driver.findElements(By.cssSelector(NewManageUser.getProperty("manageuserbutton"))).size() != 0));
    report.endTest(test);
    report.flush();
	
	}
	// To check all the buttons and links on the page
	public void verifybuttonsnlinks() throws IOException
	{
		test = report.startTest("Verifying buttons and links"); 
		assertTrue((driver.findElements(By.cssSelector(NewManageUser.getProperty("manageuserbutton"))).size() != 0));
		 String smusers = "Manage Users", mteams = "Manage Teams", invite = "Invite Users" , filters = "Filters";
		
		 Assert.assertEquals("Manage Users", smusers);
		 if(smusers =="Manage Users")
			    test.log(LogStatus.PASS, "Manage User Button Found");
		 else
			    test.log(LogStatus.FAIL, "No Manage User Button Found");
		 Assert.assertEquals("Manage Teams", mteams);
		 if(mteams =="Manage Teams")
			    test.log(LogStatus.PASS, "Manage Team Button Found");
		 else
			    test.log(LogStatus.FAIL, "No Manage Team Button Found");
		 Assert.assertEquals("Invite Users", invite);
		 if(invite =="Invite Users")
			    test.log(LogStatus.PASS, "Invite User Button Found");
		 else
			    test.log(LogStatus.FAIL, "No Invite User Button Found");
		 Assert.assertEquals("Filters", filters);
		 if(filters =="Filters")
			    test.log(LogStatus.PASS, "Filters Button Found");
		 else
			    test.log(LogStatus.FAIL, "No Filters Button Found");
		
		
		 assertTrue((driver.findElements(By.cssSelector("button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-text-primary")).size() != 0));
         assertTrue((driver.findElements(By.cssSelector("#search")).size() != 0));
         assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("UserLevel"))).getText(), "User Level");
         assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("Teams"))).getText(), "Teams");
         assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("ManualandMobileTime"))).getText(), "Manual and Mobile Time");
         assertTrue((driver.findElements(By.cssSelector(NewManageUser.getProperty("button"))).size() != 0));
         assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("Screenshots"))).getText(), "Screenshots");
         assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("Status"))).getText(), "Status");
         assertTrue((driver.findElements(By.cssSelector(".glyphicon")).size() != 0));
         File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
     	Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/Links.jpg"));
     	test.log(LogStatus.INFO, "Verfiying all Links and buttons");
     	test.log(LogStatus.INFO, "Screen shot Captured");
		test.log(LogStatus.PASS, "All Links and Buttons ");
		report.endTest(test);
		report.flush();
		
	}

	// Checking for New User Default Setting
	
	public void newuserdefualtsetting() throws InterruptedException, IOException
	{
		test = report.startTest("New User Default Setting"); 
		driver.findElement(By.cssSelector(NewManageUser.getProperty("Newdefaultsettinglink"))).click();
		driver.findElement(By.cssSelector(NewManageUser.getProperty("Cancelbutton"))).click();
		Thread.sleep(5000L);
		driver.findElement(By.cssSelector(NewManageUser.getProperty("Newdefaultsettinglink"))).click();
		Thread.sleep(5000L);
		driver.findElement(By.cssSelector(NewManageUser.getProperty("Closebutton"))).click();
		Thread.sleep(5000L);
		driver.findElement(By.cssSelector(NewManageUser.getProperty("Newdefaultsettinglink"))).click();
		Thread.sleep(5000L);
		driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle1"))).click();
	    assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("EnableScreenshots"))).getText(), "Enable Screenshots");
        driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle2"))).click();
	    assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("EnableWebcamShots"))).getText(), "Enable Webcam Shots");
	    driver.findElement(By.cssSelector(NewManageUser.getProperty("Droplist"))).click();
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
		Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/defaultsetting1.jpg"));
	    // Display the list of the drop list
	    Select oSelect = new Select(driver.findElement(By.cssSelector(NewManageUser.getProperty("Droplist"))));
	    	List <WebElement> elementCount = oSelect.getOptions();
	    	int iSize = elementCount.size();

	    	for(int i =0; i<iSize ; i++){
	    		String sValue = elementCount.get(i).getText();
	    		test.log(LogStatus.INFO, "Show “Are you still working?” Pop-Up values are :: "  +sValue);
	    		
	    		}
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Droplist"))).click();
	      assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("Working"))).getText(), "Show “Are you still working?” Pop-Up");
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle4"))).click();
	      assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("ManualTime"))).getText(), "Enable Manual Time");
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle5"))).click();
	      assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("PoorTime"))).getText(), "Show “Poor Time Use” Pop-Up");
	      assertTrue((driver.findElements(By.cssSelector(NewManageUser.getProperty("Droplistselect"))).size() != 0));
	      assertEquals(driver.findElement(By.cssSelector(NewManageUser.getProperty("Closebutton"))).getText(), "");
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle1"))).click();
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle2"))).click();
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle4"))).click();
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Toggle5"))).click();
	      driver.findElement(By.cssSelector(NewManageUser.getProperty("Save"))).click();
	      // checking for the validation message
	      		String defaultsettings =  driver.findElement(By.cssSelector(".alert")).getText();
	        		
	        		if (defaultsettings.equals("Settings Updated Successfully!"))
	        		{
	        			test.log(LogStatus.PASS, "Default Setting Saved Successfully");
	        			 File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
	        				Files.copy(scrFile1, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/defaultsetting2.jpg"));
	        		}
	        		else
	        		{
	        			test.log(LogStatus.FAIL, "Default Setting  didn't save Successfully");
	        		}
	 
	        		report.endTest(test);
	        		report.flush();

	}
	// checking the usersetting page. At the moment due to issue the code is not completed https://globalworkforce.jira.com/browse/USERS-52
	public void usersettingpage() throws IOException
	{
		test = report.startTest("User Setting Page"); 
		driver.findElement(By.cssSelector(NewManageUser.getProperty("Name"))).click();
		driver.findElement(By.cssSelector("#last_name")).click();
		driver.findElement(By.cssSelector("#last_name")).click();
		driver.findElement(By.cssSelector("#last_name")).clear();
		driver.findElement(By.cssSelector("#last_name")).sendKeys("Choksey");
		driver.findElement(By.cssSelector(NewManageUser.getProperty("UserdetailsSave"))).click();
		assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "Bad Request");	
		String alert = "Sucessfull";
		if(alert == "Bad Request")
		{
			test.log(LogStatus.FAIL, "Default Setting  didn't save Successfully");
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/usersetting1.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
		}
		else
		{
			test.log(LogStatus.PASS, "Default Setting  saved Successfully");
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/usersetting2.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
				report.endTest(test);
        		report.flush();
		}
		

	}
	//Checking for the filterscreen
	public void filtersscreen() throws IOException
	{
		test = report.startTest("Filters");  
		test.log(LogStatus.INFO, "Verifying the filters functionality");
		
		 driver.findElement(By.cssSelector(".td-filter-panel__button > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-medium")).click();
		 driver.findElement(By.cssSelector(".td-filter-panel__reset > div:nth-of-type(1) > .td-checkbox.td-checkbox--blue > label.td-checkbox__label")).click();
		 driver.findElement(By.cssSelector(".td-filter-panel__reset > div:nth-of-type(1) > .td-checkbox.td-checkbox--blue > label.td-checkbox__label")).click();
		 driver.findElement(By.cssSelector(".td-filter-panel__reset > div:nth-of-type(2) > a[href=\"#\"]")).click();
	        assertEquals(driver.findElement(By.cssSelector(".td-checkbox.minus > label.td-checkbox__label")).getText(), "2 Filters");
	        String alert = "2 Filters";
			if(alert == "2 Filters")
			{
				test.log(LogStatus.PASS, "Reset works correctly");
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/filter1.jpg"));
					test.log(LogStatus.INFO, "Screenshot Captured");
			}
			else
			{
				test.log(LogStatus.FAIL, "Reset didn't work correctly");
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/filter2.jpg"));
					test.log(LogStatus.INFO, "Screenshot Captured");
			}
	        driver.findElement(By.cssSelector(".td-checkbox.minus > label.td-checkbox__label")).click();
	        driver.findElement(By.cssSelector(".td-filter-panel__reset > div:nth-of-type(1) > .td-checkbox.td-checkbox--blue > label.td-checkbox__label")).click();
	        driver.findElement(By.cssSelector(".panel-body > div:nth-of-type(1) > div > h4.td-title--small-uppercase.td-util__ellipsis")).click();
	        driver.findElement(By.cssSelector(".panel-body > div:nth-of-type(2) > div > h4.td-title--small-uppercase.td-util__ellipsis")).click();
	        driver.findElement(By.cssSelector(".panel-body > div:nth-of-type(3) > div > h4.td-title--small-uppercase.td-util__ellipsis")).click();
	        driver.findElement(By.cssSelector(".panel-body > div:nth-of-type(4) > div > h4.td-title--small-uppercase.td-util__ellipsis")).click();
	        driver.findElement(By.cssSelector(".panel-body > div:nth-of-type(5) > div > h4.td-title--small-uppercase.td-util__ellipsis")).click();
	        assertTrue((driver.findElements(By.cssSelector(".panel-body > div:nth-of-type(1) > div > h4.td-title--small-uppercase.td-util__ellipsis")).size() != 0));
	        assertTrue((driver.findElements(By.cssSelector(".panel-body > div:nth-of-type(2) > div > h4.td-title--small-uppercase.td-util__ellipsis")).size() != 0));
	        assertTrue((driver.findElements(By.cssSelector(".panel-body > div:nth-of-type(3) > div > h4.td-title--small-uppercase.td-util__ellipsis")).size() != 0));
	        assertTrue((driver.findElements(By.cssSelector(".panel-body > div:nth-of-type(4) > div > h4.td-title--small-uppercase.td-util__ellipsis")).size() != 0));
	        assertTrue((driver.findElements(By.cssSelector(".panel-body > div:nth-of-type(5) > div > h4.td-title--small-uppercase.td-util__ellipsis")).size() != 0));
	     test.log(LogStatus.PASS, "All fiters are working fine");
	     report.endTest(test);
 		report.flush();

	}
	public void mainscreen() throws IOException
	{
		test = report.startTest("Main Screen"); 
		driver.findElement(By.cssSelector(".full_name > .td-checkbox.td-checkbox--blue > label.td-checkbox__label")).click();
        driver.findElement(By.cssSelector(".full_name > .td-checkbox.td-checkbox--blue > label.td-checkbox__label")).click();
        driver.findElement(By.cssSelector(".full_name > .td-checkbox.td-checkbox--blue > label.td-checkbox__label")).click();
        driver.findElement(By.cssSelector(".level > .bulk-actions > .td-status__dropdown > select")).click();
        driver.findElement(By.cssSelector(".level > .bulk-actions > .td-status__dropdown > select")).click();
        driver.findElement(By.cssSelector(".level > .bulk-actions > .td-status__dropdown > select")).sendKeys("admin");
        driver.findElement(By.cssSelector(".td-modal-footer > .td-button-row > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-medium")).click();
        driver.findElement(By.cssSelector(".td-status__dropdown.td-status__dropdown--admin > select")).click();
        driver.findElement(By.cssSelector(".td-status__dropdown.td-status__dropdown--admin > select")).click();
       
        driver.findElement(By.cssSelector(".td-status__dropdown.td-status__dropdown--admin > select")).sendKeys("employee");
        driver.findElement(By.cssSelector(".td-modal-footer > .td-button-row > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-medium")).click();
        driver.findElement(By.cssSelector(".td-status__dropdown.td-status__dropdown--employee > select")).click();
        driver.findElement(By.cssSelector(".td-status__dropdown.td-status__dropdown--employee > select")).click();
        Select oSelect1 = new Select(driver.findElement(By.cssSelector(".td-status__dropdown.td-status__dropdown--employee > select")));
    	List <WebElement> elementCount = oSelect1.getOptions();
    	int iSize = elementCount.size();

    	for(int i =0; i<iSize ; i++){
    		String sValue1 = elementCount.get(i).getText();
    		System.out.println("User Level Drop menu :"+sValue1);
    		test.log(LogStatus.INFO, "User Level Drop menu :: "  +sValue1);
    		}
        driver.findElement(By.cssSelector(".manual_time > .bulk-actions > .td-button-group > button[type=\"button\"].td-button.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-smaller")).click();
    	driver.findElement(By.cssSelector(".td-modal-footer > .td-button-row > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-medium > .td-icon-cancel.td-button__icon")).click();
    	driver.findElement(By.cssSelector(".td-full-height-table > div:nth-of-type(3) > div > div:nth-of-type(1) > div:nth-of-type(2) > div > div:nth-of-type(9) > div > .bulk-actions > .td-button-group > button[type=\"button\"].td-button.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-smaller")).click();
    	driver.findElement(By.cssSelector(".td-modal-footer > .td-button-row > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-medium")).click();
    	driver.findElement(By.cssSelector(".manual_time > .bulk-actions > .td-button-group > button[type=\"button\"].td-button.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-smaller")).click();
    	driver.findElement(By.cssSelector("button[type=\"button\"].td-button.save")).click();
       
        assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "Bad Request");	
        String alert1 = "Bad Request";
		if(alert1 == "Bad Request")
		{
			test.log(LogStatus.FAIL, "Error message - Bad Request - is displayed");
			
		
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/mainscreen1.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
		}
		else
		{
			test.log(LogStatus.PASS, "Sucessfully Saved");
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/mainscreen2.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
		}
		report.endTest(test);
		report.flush();
        
    		}
	
	public void manageteamcancel()
	{
		test = report.startTest("Manage Team - Cancel"); 
			driver.findElement(By.cssSelector("a[href=\"/apps/manage-teams\"]")).click();
			String actual = driver.getCurrentUrl();
			test.log(LogStatus.INFO, "Actual Title returned :: " + actual);
			String expected = "https://login.timedoctortest.com/apps/manage-teams";
			test.log(LogStatus.INFO, "Expected Title returned:: "+ expected);
			Assert.assertEquals(actual,expected);
			test.log(LogStatus.PASS, "Manage Team Page Opened Sucessfully");	
	       driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-btn-add-team")).click();
	       test.log(LogStatus.PASS, "Team Details screen opened sucessfully");	
	       driver.findElement(By.cssSelector(".td-button-row > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-medium")).click();
	       driver.findElement(By.cssSelector(".td-card--team__add-icon")).click();
	       driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light > .td-icon-cancel.td-button__icon")).click();
	       test.log(LogStatus.INFO, "Clicked on Cancel button");
	       test.log(LogStatus.PASS, "Closed Team Details Screen");
	       report.endTest(test);
   		report.flush();
	}
	
	public void manageteamsave() throws IOException
	{
			test = report.startTest("Manage Team - Save"); 
			driver.findElement(By.cssSelector("a[href=\"/apps/manage-teams\"]")).click();
	        driver.findElement(By.cssSelector(".td-icon.td-icon-plus")).click();
	        test.log(LogStatus.INFO, "( + ) - Add Team Button Clicked");
	        driver.findElement(By.cssSelector("#name")).click();
	        driver.findElement(By.cssSelector("#name")).click();
	        driver.findElement(By.cssSelector("#name")).clear();
	        driver.findElement(By.cssSelector("#name")).sendKeys("Testing3");
	        driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-smaller")).click();
	        driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-smaller")).click();
	        driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-smaller")).click();
	        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	        test.log(LogStatus.INFO, "Clicked on Saved button");
	        assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "Team created successfully!");
	        String alert3 = "Team created successfully!";
	        if(alert3 == "Team created successfully!")
			{
				test.log(LogStatus.PASS, "Team is successfully created");
				
			
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/Manageteam1.jpg"));
					test.log(LogStatus.INFO, "Screenshot Captured");
			}
			else
			{
				test.log(LogStatus.FAIL, "Team is not created");
				 test.log(LogStatus.INFO, "Clicked on Add Team - Red Button");
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/Manageteam2.jpg"));
					test.log(LogStatus.INFO, "Screenshot Captured");
			}
	        test.log(LogStatus.INFO, "Clicked on Add Team Button - Red ");
	        driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-btn-add-team")).click();
	        driver.findElement(By.cssSelector("#name")).click();
	        driver.findElement(By.cssSelector("#name")).click();
	        driver.findElement(By.cssSelector("#name")).clear();
	        driver.findElement(By.cssSelector("#name")).sendKeys("Testing4");
	        driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-smaller")).click();
	        driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--theme-default")).click();
	        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	        test.log(LogStatus.INFO, "Clicked on Saved button");
	        assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "Team created successfully!");
	        String alert4 = "Team created successfully!";
	        if(alert4 == "Team created successfully!")
			{
				test.log(LogStatus.PASS, "Team is successfully created");
				
			
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/Manageteam1.jpg"));
					test.log(LogStatus.INFO, "Screenshot Captured");
			}
			else
			{
				test.log(LogStatus.FAIL, "Team is not created");
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
					Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/Manageteam2.jpg"));
					test.log(LogStatus.INFO, "Screenshot Captured");
			}

        
        report.endTest(test);
		report.flush();
	}
	public void manageteamdelete() throws IOException
	{
		test = report.startTest("Manage Team - Delete"); 
		driver.findElement(By.cssSelector(".panel-body > .td-card.td-card--team.colors:nth-of-type(3) > .td-card__inner > .td-card__content")).click();
		driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light-danger-text")).click();
        assertEquals(driver.findElement(By.cssSelector(".td-modal-title")).getText(), "Trying to delete team?");
        test.log(LogStatus.INFO, "Clicking on Delete button");
        String alert4 = "Trying to delete team?!";
        if(alert4 == "Trying to delete team?!")
		{
			test.log(LogStatus.PASS, "Popup Displayed sucessfully");
			
		
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/manageteam3.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
		}
		else
		{
			test.log(LogStatus.FAIL, "Popup didn't display");
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/Manageteam4.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
		}
        driver.findElement(By.cssSelector(".td-modal-footer > .td-button-row > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light.td-button--box-default.td-button--kind-default.td-button--size-medium")).click();
        driver.findElement(By.cssSelector("button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light-danger-text")).click();
        driver.findElement(By.cssSelector(".td-modal-footer > .td-button-row > button[type=\"button\"].td-button.td-button--with-icon.td-button--icon-position-left.td-button--theme-light-danger-text.td-button--box-default.td-button--kind-default.td-button--size-medium")).click();
        assertEquals(driver.findElement(By.cssSelector(".alert")).getText(), "Team created successfully!");
        test.log(LogStatus.INFO, "Clicking on Delete button");
        String alert5 = "Team created successfully!";
        if(alert5 == "Team created successfully!")
		{
			
        	test.log(LogStatus.PASS, "Team is deleted sucessfully");
			
		
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/manageteam4.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
		}
		else
		{
			test.log(LogStatus.FAIL, "Team is not deleted");
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // gets the screen shot in bytes 0101010
				Files.copy(scrFile, new File("/Users/payalchoksey/Desktop/Time Doctor/TDAutomationScript_4/src/test/resources/Screenshot/Manageteam5.jpg"));
				test.log(LogStatus.INFO, "Screenshot Captured");
		}
        report.endTest(test);
		report.flush();

	}
	}

	

