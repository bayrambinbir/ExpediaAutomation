package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public void setUserName(String username) {
     driver.findElement(By.xpath("//input[@name='groupID']")).sendKeys(username);
	}

	public void setUserPassword(String password) {
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    
	}

	public void clickSubmit() {
driver.findElement(By.xpath("//input[@type='button']")).click();
	}

	// constructor initializes the state of the driver
	public LoginPage(WebDriver driver) {
     this.driver= driver;
	}

}
