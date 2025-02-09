package co.giva.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.base.TestBase;
import pom.pages.HomePage;
import pom.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;//after log in
	String sheetName = "Sheet1";

	public LoginPageTest() {
		super();//to call super class constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 2)
	public void loginPageTitleTest() {
		logger.info("logingTest Method Running");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Account – GIVA Jewellery");
	}
	
	@Test(priority = 3)
	public void verifyPageUrlTest() {
		String url = loginPage.verifyLoginPageUrl();
		Assert.assertEquals(url, "https://www.giva.co/account/login", "URL mismatch");
	}

	@Test(priority = 4)
	public void verifyCurrentPageUrl() {
		String currenturl = loginPage.verifyCurrentPageUrl();
		Assert.assertEquals(currenturl, "https://www.giva.co/account/login", "URL mismatch");
	}
	@Test(priority = 5)
	public void verifyPageSource() {
		loginPage.getWindowhandleid();
	}

	@Test(priority = 1)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}



	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
