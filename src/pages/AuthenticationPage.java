package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {

	WebDriver driver;
	WebElement EmailAddress;
	WebElement password;
	WebElement signIn;
	WebElement signOut;
	WebElement confimartionError;
	
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailAddress() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignIn() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getSignOut() {
		return driver.findElement(By.className("logout"));
	}
	
	public WebElement getConfimartionError() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/p"));
	}


	public void insertEmail (String email) {
		this.getEmailAddress().clear();
		this.getEmailAddress().sendKeys(email);
	}
	
	public void insertPassword(String password) {
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
	}
	
	
}
