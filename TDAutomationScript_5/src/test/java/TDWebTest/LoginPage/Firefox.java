package TDWebTest.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.Status;

public class Firefox {
public static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		driver = new SafariDriver();
	
		driver.get("https://www.google.com");

	}

}
