package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWhishlistsPage {
	
	WebDriver driver;
	WebElement nameList;
	WebElement saveList;
	WebElement confirmationSaveforOneList;
	WebElement confirmationForMultipleList;
	WebElement delete;

	public MyWhishlistsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNameList() {
		return driver.findElement(By.id("name"));
	}
	
	public void insertNameList (String name) {
		this.getNameList().clear();
		this.getNameList().sendKeys(name);
	}

	public WebElement getSaveList() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getConfirmationSaveforOneList() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr/td[1]/a"));
	}

	public WebElement getConfirmationForMultipleList() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[2]/td[1]/a"));
	}

	public WebElement getDelete() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a/i"));
	}

	
	 
}
