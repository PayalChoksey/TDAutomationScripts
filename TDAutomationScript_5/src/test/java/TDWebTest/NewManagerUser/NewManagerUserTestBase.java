package TDWebTest.NewManagerUser;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TDWebTest.LoginPage.TDWeb_001;

public class NewManagerUserTestBase extends TDWeb_002{
	
	
	@BeforeTest
	public void Login() throws InterruptedException, IOException
	{
		TDWeb_001 a = new TDWeb_001();
		a.intializing();
		
		
		
	}
	@Test (priority =1)
	public void login() throws InterruptedException, IOException
	{
		TDLogin();
		 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
@Test (priority = 2)
	public void managinguserlinks() throws InterruptedException, IOException
	{
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		manageuserlink();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		verifybuttonsnlinks();
		 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		 Thread.sleep(5000L);

	}
	@Test (priority = 4)
	public void userdetails() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		usersettingpage();
	}
	@Test (priority = 5)
	public void inviteusers() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		invitation();
	}
	@Test (priority = 6)
	public void defaultsettings() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		newuserdefualtsetting();
	}
	
	@Test (priority = 7)
	public void filters() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		filtersscreen();
	}
	@Test (priority = 3)
	public void newmanageuserscreen() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		mainscreen();
	}
	@Test (priority = 8)
	public void cancelmanageteam() throws InterruptedException, IOException
	{
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		manageteamcancel();
		
	}
	@Test (priority = 9)
	public void savemanageteam() throws InterruptedException, IOException
	{
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		manageteamsave();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		manageteamdelete();
	}
	
	}
