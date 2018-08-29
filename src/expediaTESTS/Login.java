package expediaTESTS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Login {
	WebDriver driver;

	@Test
	public void loginTestPOM() {

		// initializing driver
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "/Users/bayrambinbir/Documents/selenium/drivers/chromedriver");
        driver.get("http://www.sdettraining.com/courses/login.html");
		
        //enter the login information
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("tim@testemail.com");
        loginPage.setUserPassword("trpass");
        loginPage.clickSubmit();
        
        //get the confirmation dashboard
        DashboardPage dashboardPage = new DashboardPage(driver);
        
	}
}
