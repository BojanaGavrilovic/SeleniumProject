package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	WebDriver driver;
	WebElement SignIn;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getSignIn() {
		return driver.findElement(By.className("login"));
	}
	
	

}
