package TestNgTestSessions.TestNgTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GooglefeatureTest {
	
	// make sure put Webdriver driver; so we can use through the program
	// we can define the test case execution order to run by 'priority' keyword mention next to @Test annotations
	// sequence of execution @BeforeMethod , @Test(P=1), @AfterMethod -- @BeforeMethod , @Test (P=2), @AfterMethod
	// when we refresh out project 'test- output' folder create which shows output of our test result
	// in test- output folder, one 'index.html file' we need to right click- click on 'properties' - copy the 'location'- 
	// paste on browser -click - output in HTML report
	// we  can define 'groups' keyword as well
	// we can define 'dependsOnMethods' where one method depend on another 

	WebDriver driver;
	
	@BeforeMethod //1 //4 //7
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe\\");
		driver=new ChromeDriver(); //launch Chrome
		driver.manage().window().maximize();// maximise window
		driver.manage().deleteAllCookies();// delete all the cookies
		driver.get("https://google.com");// Enter the URL
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);// page load wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority=1,groups="Title")//2
	public void googleTitleTest() {
		String title = driver.getTitle();// get google title
		System.out.println(title);// print title on console
		int i =9/0;
	}
	@Test(priority=2,groups="Logo",dependsOnMethods="googleTitleTest") //5
	public void googleLogoTest() {
		boolean b = driver.findElement(By.xpath("//img[@id=\"hplogo\"]")).isDisplayed();// google logo
	}
	@Test(priority=3,groups="Title") //8
	public void gmailLinkTest() {
		boolean b1  = driver.findElement(By.linkText("Gmail")).isDisplayed();// gmail link
	}
	@AfterMethod //3 //6 //9
	public void teardown() {
		driver.quit();
	}
}
