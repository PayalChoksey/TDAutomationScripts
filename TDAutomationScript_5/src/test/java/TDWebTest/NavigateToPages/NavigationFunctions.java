package TDWebTest.NavigateToPages;

import org.testng.Assert;

import TDWebTest.GlobalProperties.TDWeb_GlobalSetup;

public class NavigationFunctions extends TDWeb_GlobalSetup {

	private NavigationObjects navigate = new NavigationObjects(driver);
	
	public void GoToTimesheetPage() {
		// Navigate to Timesheet page
		navigate.reportsLink().click();
		navigate.reportsTimesheetLink().click();
		
	}
	
	public void GoToTimeUsePage() {
		navigate.reportsLink().click();
		navigate.reportsTimeUseLink().click();
	}
	
	public void GoToTimelinePage() {
		navigate.reportsLink().click();
		navigate.reportsTimelineLink().click();
	}
	
	public void GoToCompanySettings() {
		navigate.companySectionToggle().click();
		navigate.companySettingsLink().click();
	}
	
	public void GoToNewEditTimePage() {
		navigate.editTimeLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/#/edit-time"));
	}
	
}