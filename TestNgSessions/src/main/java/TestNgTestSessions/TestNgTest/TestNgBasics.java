package TestNgTestSessions.TestNgTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNgBasics {
	

	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("Launch Browser");
	}
	@Test
	public void launch() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe\\");

		WebDriver driver=new ChromeDriver(); //launch Chrome
		
		driver.manage().window().maximize();// maximise window
		
		driver.manage().deleteAllCookies();// delete all the cookies
		
		driver.get("https://opensource-demo.orangehrmlive.com/");// Enter the URL

		System.out.println("hello");
	}
	@AfterSuite
	public void stop() {
		System.out.println("1");
	}
	
	
	

}
