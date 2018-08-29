package expediaTESTS;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {

	WebDriver driver;
	String city = "New York, NY";
	String checkIn = "08/30/2018";
	String checkOut = "09/10/2018";
	String numOfGuest = "2";

	@Test
	public void hotelRezervation() {

		// 1 Search for hotel in New York

		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.name("destination")).sendKeys(city);

		// Modifying check in date
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);

		// Modifying check out date
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();;
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
		
		// Selecting (traveler box) Quest Number
		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[4]/div[3]/div/ul/li/button")).click();
        
		// decreases the adult number by 1 
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[4]/div[3]/div/ul/li/div/div/div/div[2]/div[2]/button")).click();
		
		// increase the child quantity by 1
		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[4]/div[3]/div/ul/li/div/div/div/div[3]/div[1]/div[4]/button")).click();
		
		// Enter the child age
		 Select childAge = new Select(driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel']/div[4]/div[3]/div/ul/li/div/div/div/div[3]/div[2]/label[1]/select")));
		    childAge.selectByIndex(2);
		    
		
		    // Closes the (traveler box) Quest tab
		driver.findElement(By.xpath("//*[@id='gcw-hotel-form-hp-hotel\']/div[4]/div[3]/div/ul/li/div/footer/div/button")).click();
		
		// Search BUtton
		driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
		
		//Print the city name   /????????
		String actualCity = driver.findElement(By.xpath("//*[@id='searchWizard']/div[2]/div[1]/div/div[1]/div[1]/div[1]/button")).getText();
		System.out.println("Your selected city is :"+ actualCity);
		
		// Selecting for 4 Star hotels
		driver.findElement(By.cssSelector("input[name='star'][id='star4']")).click();
		//*[@id="star4"]driver.findElement(By.xpath("//*[@id=\"star4\"]")).click();
				
	   // Choose the 3rd Hotel
		driver.findElement(By.xpath("//*[@id=\"resultsContainer\"]/section/article[3]/div[2]/div/a")).click();
		
		// Switch the window to the pop up
		driver.getWindowHandle();
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		// Print the hotelName
		String hotelName = driver.findElement(By.id("hotel-name")).getText();
		System.out.println("Hotel name is "+hotelName);
		
		// reserving the hotel
		driver.findElement(By.xpath("//*[@id=\"rooms-and-rates\"]/div/article/table/tbody[1]/tr[1]/td[4]/div/form/div[1]/button")).click();
        //String tripTotal = driver.findElement(By.xpath("//*[@id=\"trip-summary\"]/div[2]/div[5]/div/span[2]")).getText(); ///OR 
        String tripTotal2 = driver.findElement(By.cssSelector("span[class='summary-total amount-value']")).getText();
        System.out.println("Your trip total :"+tripTotal2);
        
        // CONFirmation that you are in the payment page
        String paymentPageTitle = driver.getTitle();
        Assert.assertTrue(paymentPageTitle.contains("Payment"));
        System.out.println("Payment window title :"+paymentPageTitle);
	}

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/bayrambinbir/Documents/selenium/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.expedia.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		// driver.quit();

	}

}