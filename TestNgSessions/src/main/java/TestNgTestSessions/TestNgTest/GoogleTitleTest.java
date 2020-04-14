package TestNgTestSessions.TestNgTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
	// we do validation in the form of assertion 
	// Assert class and his method : assert.equals( actual result, "expected result", "title is not matched");
	//Assert.assertEquals(title, "Google" , "title is not matched");
	//Assert.assertTrue(); // google logo displayed //	Assert.assertTrue(b, "logo is not displayed");

	WebDriver driver;
	@BeforeMethod 
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe\\");
		driver=new ChromeDriver(); //launch Chrome
		driver.manage().window().maximize();// maximise window
		driver.manage().deleteAllCookies();// delete all the cookies
		driver.get("https://google.com");// Enter the URL
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);// page load wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test()
	public void googleTitleTest() {
		String title = driver.getTitle();// get google title
		System.out.println(title);// print title on console
		
		Assert.assertEquals(title, "Google" , "title is not matched");
	}
	@Test() 
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//img[@id=\"hplogo\"]")).isDisplayed();// google logo
	//	Assert.assertTrue(b, "logo is not displayed");
		Assert.assertEquals(b,true);
	}
	@AfterMethod 
	public void teardown() {
		driver.quit();
	}
}
