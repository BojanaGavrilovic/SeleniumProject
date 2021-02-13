package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAccountPagee;

public class SignInTests extends TestBase {
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
 
	@Test (priority = 5)
	public void signInWithValidCredentials () throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		String myaccount = excel.getStringData("Sign in", 8, 7);
		
		signIn(email, password);
		
		String textForAssert = myAccountPage.getConfirmationText().getText();
		Assert.assertEquals(textForAssert, myaccount);		
	}
	
	//@Test (priority = 10)
	public void sigInWithvalidEmailAndInvalidPassword () throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 13, 5);
		String password = excel.getStringData("Sign in", 14, 5);
		String error = excel.getStringData("Sign in", 15, 7);
		
		signIn(email, password);
		
		String textForAssert1 = authePage.getConfimartionError().getText();
		Assert.assertEquals(textForAssert1, error);
	}
	
	//@Test (priority = 15)
	public void sigInWithinvalidEmailAndvalidPassword () throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 20, 5);
		String password = excel.getStringData("Sign in", 21, 5);
		String error = excel.getStringData("Sign in", 22, 7);
		
		signIn(email, password);
		
		String textForAssert2 = authePage.getConfimartionError().getText();
		Assert.assertEquals(textForAssert2, error);
	}
	
	//@Test (priority = 20)
	
	public void sigInWithinvalidEmailAndinvalidPassword () throws InterruptedException{
		
		String email = excel.getStringData("Sign In", 27, 5);
		String password = excel.getStringData("Sign in", 28, 5);
		String error = excel.getStringData("Sign in", 29, 7);
		
		signIn(email, password);
		
		String textForAssert3 = authePage.getConfimartionError().getText();
		Assert.assertEquals(textForAssert3, error);
	}
	
	//@Test (priority = 25)
	public void signInWithEmptyCredentials () throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 34, 5);
		String password = excel.getStringData("Sign in", 35, 5);
		String error = excel.getStringData("Sign in", 36, 7);
		
		signIn(email, password);
		
		String textForAssert4 = authePage.getConfimartionError().getText();
		Assert.assertEquals(textForAssert4, error);
	}
	
	@Test (priority = 30)
	public void SignOut ()throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		String signIn = excel.getStringData("SignOut", 3, 8);
		
		signIn(email, password);
		authePage.getSignOut().click();
		Thread.sleep(2000);
		
		String textForAssert5 = authePage.getSignIn().getText();
		Assert.assertEquals(textForAssert5, signIn);
		
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}	
	
	

}
