package TDWebTest.RedirectingPagesTestServer;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class UtilityRedirectingPage {
	
	public static void capturescreenshot(WebDriver driver, String screenshotname) throws IOException
	{
	
	TakesScreenshot screenshot = (TakesScreenshot)driver;
	File source = screenshot.getScreenshotAs(OutputType.FILE);
	Files.copy(source, new File("src/test/resources/Screenshot/RedirectingPages/"+screenshotname+".jpg"));
	

}
	public static void pausing() throws InterruptedException
	{
		Thread.sleep(2000L);
	}
}

