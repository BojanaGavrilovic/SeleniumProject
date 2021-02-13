package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInformationTests extends TestBase {
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(10000);
	}

	@Test (priority = 5)
	public void editPersonalInformation ()  throws InterruptedException {
		
		String email = excel.getStringData("Sign In", 6, 5);
		String password = excel.getStringData("Sign in", 7, 5);
		String firstName = excel.getStringData("MyPersonalInformation", 4, 6);
		String lastName = excel.getStringData("MyPersonalInformation", 5, 6);
		String email1 = excel.getStringData("MyPersonalInformation", 6, 6);
		String currentPassword = excel.getStringData("MyPersonalInformation", 7, 6);
		String newPassword = excel.getStringData("MyPersonalInformation", 8, 6);
		String confirmationPassword = excel.getStringData("MyPersonalInformation", 9, 6);
		String confirmationForEdit = excel.getStringData("MyPersonalInformation", 10, 8);
		
		
		signIn(email, password);
		edit(firstName, lastName, email1, currentPassword, newPassword, confirmationPassword);
	
		String textForAssert = myPersonalInfoPage.getConfirmationForEdit().getText();
		Assert.assertEquals(textForAssert, confirmationForEdit);
		
	}
	@Test (priority = 10)
	public void returnPersonalInformation () throws InterruptedException {
		
		String email2 = excel.getStringData("MyPersonalInformation", 15, 6);
		String password2 = excel.getStringData("MyPersonalInformation", 16, 6);
		String firstName = excel.getStringData("MyPersonalInformation", 19, 6);
		String lastName = excel.getStringData("MyPersonalInformation", 20, 6);
		String email1 = excel.getStringData("MyPersonalInformation", 21, 6);
		String currentPassword = excel.getStringData("MyPersonalInformation", 22, 6);
		String newPassword = excel.getStringData("MyPersonalInformation", 23, 6);
		String confirmationPassword = excel.getStringData("MyPersonalInformation", 24, 6);
		String confirmationForEdit = excel.getStringData("MyPersonalInformation", 25, 8);
		
		signIn(email2, password2);
		edit(firstName, lastName, email1, currentPassword, newPassword, confirmationPassword);
		
		String textForAssert = myPersonalInfoPage.getConfirmationForEdit().getText();
		Assert.assertEquals(textForAssert, confirmationForEdit);
		
	}
	
	@AfterMethod
	public void afterTest() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		Thread.sleep(2000);
	}	
	
	public void edit (String firstName, String lastName, String email,String currentPassword, String newPassword, 
			String confirmationPassword) throws InterruptedException {
		
		myAccountPage.getMyPersonalInformation().click();
		Thread.sleep(2000);
		myPersonalInfoPage.insertFirstName(firstName);
		Thread.sleep(2000);
		myPersonalInfoPage.insertLastName(lastName);
		Thread.sleep(2000);
		myPersonalInfoPage.insertEmail(email);
		Thread.sleep(2000);
		myPersonalInfoPage.inesertCurrentPassword(currentPassword);
		Thread.sleep(2000);
		myPersonalInfoPage.insertNewPassword(newPassword);
		Thread.sleep(2000);
		myPersonalInfoPage.insertConfirmationPassword(confirmationPassword);
		Thread.sleep(2000);
		myPersonalInfoPage.getSave().click();
		Thread.sleep(2000);
	}
	
}
