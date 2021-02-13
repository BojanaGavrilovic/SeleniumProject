package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	
	WebDriver driver;
	WebElement update;
	WebElement fieldAddress;
	WebElement save;
	WebElement updateAddressConfirmation;
	WebElement buttonAddANewAddress;
	WebElement city;
	WebElement state;
	WebElement postalCode;
	WebElement homePhone;
	WebElement mobilePhone;
	WebElement addressForFutureReference;
	WebElement newAddressConfirmation;
	WebElement delete;
	
	public MyAddressesPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUpdate() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public WebElement getFieldAddress() {
		return driver.findElement(By.id("address1"));
	}
	
	public void insertAddress (String address) {
		this.getFieldAddress().clear();
		this.getFieldAddress().sendKeys(address);
	}
	
	
	public WebElement getSave() {
		return driver.findElement(By.id("submitAddress"));
	}

	public WebElement getupdateAddressConfirmation() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getButtonAddANewAddress() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/a"));
	}

	public WebElement getCity() {
		return driver.findElement(By.id("city"));
	}

	public void insertCity (String city) {
		this.getCity().clear();
		this.getCity().sendKeys(city);
	}
	
	public WebElement getState() {
		return driver.findElement(By.id("id_state"));
	}
	
	public WebElement getPostalCode() {
		return driver.findElement(By.id("postcode"));
	}
	
	public void insertPostalCode (String postalCode) {
		this.getPostalCode().clear();
		this.getPostalCode().sendKeys(postalCode);
	}

	public WebElement getHomePhone() {
		return driver.findElement(By.id("phone"));
	}
	
	public void insertHomePhone (String homePhone) {
		this.getHomePhone().clear();
		this.getHomePhone().sendKeys(homePhone);
	}

	public WebElement getMobilePhone() {
		return driver.findElement(By.id("phone_mobile"));
	}
	
	public void insertMobilePhone (String mobilePhone) {
		this.getMobilePhone().clear();
		this.getMobilePhone().sendKeys(mobilePhone);
	}

	public WebElement getAddressForFutureReference() {
		return driver.findElement(By.id("alias"));
	}
	
	public void insertAddressForReference (String addressForReference) {
		this.getAddressForFutureReference().clear();
		this.getAddressForFutureReference().sendKeys(addressForReference);
	}

	public WebElement getNewAddressConfirmation() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div[2]/ul/li[1]/h3"));
	}

	public WebElement getDelete() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[1]/div/div[2]/ul/li[9]/a[2]"));
	}

	
	
}
