package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInformationPage {

	WebDriver driver;

	WebElement firstName;
	WebElement lastName;
	WebElement email;
	WebElement currentPassword;
	WebElement newPassword;
	WebElement confirmationPassword;
	WebElement save;
	WebElement confirmationForEdit;
	

	public MyPersonalInformationPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirstName() {
		return driver.findElement(By.id("firstname"));
	}
	
	public void insertFirstName (String firstName) {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);;
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("lastname"));
	}

	public void insertLastName (String lastName) {
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
	}
	
	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}

	public void insertEmail (String email) {
		this.getEmail().clear();
		this.getEmail().sendKeys(email);
	}
	
	public WebElement getCurrentPassword() {
		return driver.findElement(By.id("old_passwd"));
	}

	public void inesertCurrentPassword (String currentPassword) {
		this.getCurrentPassword().clear();
		this.getCurrentPassword().sendKeys(currentPassword);
	}
	
	public WebElement getNewPassword() {
		return driver.findElement(By.id("passwd"));
	}

	public void insertNewPassword (String newPassword) {
		this.getNewPassword().clear();
		this.getNewPassword().sendKeys(newPassword);
	}

	public WebElement getConfirmationPassword() {
		return driver.findElement(By.id("confirmation"));
	}

	public void insertConfirmationPassword (String confirmationPassword) {
		this.getConfirmationPassword().clear();
		this.getConfirmationPassword().sendKeys(confirmationPassword);
	}
	
	public WebElement getSave() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/form/fieldset/div[11]/button/span"));
	}


	public WebElement getConfirmationForEdit() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/p"));
	}
	
	
	
	
	
}
