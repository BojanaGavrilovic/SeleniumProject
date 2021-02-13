package tests;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressesTests extends TestBase {

	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	//@Test (priority = 5)
	public void updateAddresses()  throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		String address = excel.getStringData("MyAddresses", 5, 6);
		String confirmation = excel.getStringData("MyAddresses",6, 8);
		
		signIn(email, password);
		myAccountPage.getMyAddresses().click();
		Thread.sleep(2000);
		myAddressesPage.getUpdate().click();
		Thread.sleep(2000);
		myAddressesPage.insertAddress(address);
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		myAddressesPage.getSave().click();
		Thread.sleep(2000);
		
		String textForAssert = myAddressesPage.getupdateAddressConfirmation().getText(); 
		Assert.assertEquals(textForAssert, confirmation);
		
	}
	
	@Test (priority = 10)
	public void addAddresses ()  throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		String address2 = excel.getStringData("MyAddresses", 10, 6);
		String city = excel.getStringData("MyAddresses", 11, 6);
		String postalCode = String.valueOf(excel.getIntData("MyAddresses",13, 6));
		String homePhone = String.valueOf(excel.getIntData("MyAddresses", 14, 6));
		String mobilePhone = String.valueOf(excel.getIntData("MyAddresses", 15, 6));
		String addressReference = excel.getStringData("MyAddresses", 16, 6);
		String confirmation = excel.getStringData("MyAddresses",17, 8);
		
		signIn(email, password);
		myAccountPage.getMyAddresses().click();
		Thread.sleep(2000);
		myAddressesPage.getButtonAddANewAddress().click();
		Thread.sleep(2000);
		myAddressesPage.insertAddress(address2);
		Thread.sleep(2000);
		myAddressesPage.insertCity(city);
		Thread.sleep(2000);
		myAddressesPage.getState().click();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		myAddressesPage.insertPostalCode(postalCode);
		Thread.sleep(2000);
		myAddressesPage.insertHomePhone(homePhone);
		Thread.sleep(2000);
		myAddressesPage.insertMobilePhone(mobilePhone);
		Thread.sleep(2000);
		myAddressesPage.insertAddressForReference(addressReference);
		Thread.sleep(2000);
		myAddressesPage.getSave().click();
		Thread.sleep(2000);
		
		String textForAssert2 = myAddressesPage.getNewAddressConfirmation().getText();
		Assert.assertEquals(textForAssert2, confirmation);

	}
	
	@Test (priority = 15)
	
	public void deleteAddress () throws InterruptedException {
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		
		signIn(email, password);
		myAccountPage.getMyAddresses().click();
		Thread.sleep(2000);
		myAddressesPage.getDelete().click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		String textForAssert = null;
		Assert.assertNull(textForAssert);
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
		
	}	
	
}
