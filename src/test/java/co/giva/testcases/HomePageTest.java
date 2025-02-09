package co.giva.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.xml.internal.TestNamesMatcher;
import pom.pages.HomePage;
import pom.pages.LoginPage;
import pom.base.TestBase;
import pom.pages.MensJewelleryPage;
import pom.pages.ProductPage;

import java.util.List;

public class HomePageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ProductPage ringpage;
    MensJewelleryPage mensproduct;
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(driver);
        homePage = new HomePage();
        ringpage=new ProductPage();
        mensproduct=new MensJewelleryPage();

        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        loginPage.viewHomePage();
    }

    @Test
    public void validateHomePageTitleTest() {
       //logger.info("HomePage Test Method Running");
        String title = homePage.verifyHomePageTitle();
        Assert.assertEquals(title, "Buy Pure Silver and Gold Jewellery Online | Lab Grown Diamonds – GIVA Jewellery");
    }
    @Test
    public void verifyLogoDisplayedTest() {
        homePage.isLogoDisplayed();
        //Assert.assertTrue(isLogoVisible);
    }

    @Test
    public void verifyPageUrlTest() {
        String url = homePage.verifyHomePageUrl();
        Assert.assertEquals(url, "https://www.giva.co/", "https://www.giva.co/");
    }

    @Test
    public void performSearchTest() {
        homePage.performSearch("pendant");
      //  Assert.assertTrue(driver.getCurrentUrl().contains("giva"), "Search functionality is not working");
    }

    @Test
    public void verifyBestSellersLinkClickableTest() {
        boolean isClickable = homePage.isBestSellersLinkClickable();
        Assert.assertTrue(isClickable, "Best Sellers link is not clickable");
    }

    @Test
    public void navigateToBestSellersTest() {
        String bestSellersUrl = homePage.navigateToBestSellers();
        Assert.assertTrue(bestSellersUrl.contains("diamond-collection"), "Failed to navigate to the Best Sellers page");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
