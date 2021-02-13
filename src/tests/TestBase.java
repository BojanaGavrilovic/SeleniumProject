package tests;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthenticationPage;
import pages.HomePage;
import pages.MyAccountPagee;
import pages.MyAddressesPage;
import pages.MyPersonalInformationPage;
import pages.MyWhishlistsPage;

public class TestBase {

	WebDriver driver;
	ReadDataFromExcel excel;
	Actions action;
	Alert alert;
	
	//Pages
	HomePage homePage;
	AuthenticationPage authePage;
	MyAccountPagee myAccountPage;
	MyAddressesPage myAddressesPage;
	MyPersonalInformationPage myPersonalInfoPage;
	MyWhishlistsPage myWishlists;

	
	@BeforeClass
	public void preKlase() throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
		
		this.driver = new ChromeDriver();
		this.action = new Actions (driver);
		
		this.homePage = new HomePage(driver);
		this.authePage = new AuthenticationPage(driver);
		this.myAccountPage = new MyAccountPagee(driver);
		this.myAddressesPage = new MyAddressesPage(driver);
		this.myPersonalInfoPage = new MyPersonalInformationPage(driver);
		this.myWishlists = new MyWhishlistsPage(driver);
		
		excel = new ReadDataFromExcel("data/TestCase.xlsx");
		driver.manage().window().maximize();
		
	}
	
	
	public void signIn(String email, String password) throws InterruptedException {
		homePage.getSignIn().click();
		Thread.sleep(2000);
		authePage.insertEmail(email);
		Thread.sleep(2000);
		authePage.insertPassword(password);
		Thread.sleep(2000);
		authePage.getSignIn().click();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void posleKlase() {
		driver.close();
	}

	
	
}
