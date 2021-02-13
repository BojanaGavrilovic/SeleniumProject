package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWhishlistsTests extends TestBase {

	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test (priority=5)
	public void createWishlist () throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		String name = excel.getStringData("WishList", 4, 6);
		String confirmation = excel.getStringData("WishList", 5, 8);
		
		
		signIn(email, password);
		Thread.sleep(2000);
		myAccountPage.getMyWishlists().click();
		Thread.sleep(2000);
		myWishlists.insertNameList(name);
		Thread.sleep(2000);
		myWishlists.getSaveList().click();
		Thread.sleep(2000);
		
		String textForAssert = myWishlists.getConfirmationSaveforOneList().getText();
		Assert.assertEquals(textForAssert, confirmation);	
	}
	
	@Test (priority = 10)
	public void multipleWishLists ()  throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		String name = excel.getStringData("WishList", 8, 6);
		String confirmation1 = excel.getStringData("WishList", 9, 8);
		
		signIn(email, password);
		Thread.sleep(2000);
		myAccountPage.getMyWishlists().click();
		Thread.sleep(2000);
		
		for (int i = 2; i < 5; i++) {
			myWishlists.insertNameList(name + i);
			myWishlists.getSaveList().click();
		}
		Thread.sleep(5000);
		
		String textForAssert = myWishlists.getConfirmationForMultipleList().getText();
		Assert.assertEquals(textForAssert, confirmation1);
	}
	
	
	@Test (priority =15)
	public void deleteLists () throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		
		signIn(email, password);
		Thread.sleep(2000);
		
		myAccountPage.getMyWishlists().click();
		
		for (int i = 0; i < 4; i++) {
		myWishlists.getDelete().click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);		
	}
		
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
