package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPagee {

	WebDriver driver;
	WebElement confirmationText;
	//page
	WebElement myAddresses;
	WebElement myPersonalInformation;
	WebElement myWishlists;
	
	
	public MyAccountPagee(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getConfirmationText() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/h1"));
	}

	public WebElement getMyAddresses() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[3]/a/span"));
	}

	
	public WebElement getMyPersonalInformation() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[4]/a/span"));
	}

	public WebElement getMyWishlists() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[2]/ul/li/a/span"));
	}
	
	
	
	
}
