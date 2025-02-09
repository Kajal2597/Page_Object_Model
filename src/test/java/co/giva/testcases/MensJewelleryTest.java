package co.giva.testcases;

import lombok.var;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.base.TestBase;
import pom.pages.HomePage;
import pom.pages.LoginPage;
import pom.pages.MensJewelleryPage;
import pom.pages.ProductPage;

import java.util.ArrayList;
import java.util.List;

public class MensJewelleryTest extends TestBase
{


    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    MensJewelleryPage mensPage;

    public MensJewelleryTest(){super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        Thread.sleep(5000);
        // testUtil =new TestUtil();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        mensPage= new MensJewelleryPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.viewHomePage();
        homePage.viewMensJewellery();

        Thread.sleep(5000);
    }

    @Test
    public void viewAllProducts() throws InterruptedException{
        //  logger.info("Pendal page Test Method Running");

        Thread.sleep(2000);
        mensPage = homePage.viewMensJewellery();
        Thread.sleep(5000);
    }

    @Test
    public void validatePageURLTest() {
        String title = mensPage.verifyMensPageUrl();
        Assert.assertEquals(title,"https://www.giva.co/collections/mens-silver-jewellery");
    }

    @Test
    public void validatePageTitleTest() {
        String title = mensPage.verifyMensPageTitle();
        Assert.assertEquals(title, "Men's Silver Jewellery | Stylish Designs – GIVA Jewellery");

    }
    @Test
    public void clickViewAllProductsTest() {
        mensPage.clickViewAllProducts();
        Assert.assertTrue(driver.getCurrentUrl().contains("mens-silver-jewellery"), "Failed to navigate to 'View All Products'");
    }
    @Test
    public void validateProductPricesTest() throws InterruptedException {
        List<String> prices = mensPage.getAllProductPrices();
        System.out.println(prices);
      //  Assert.assertEquals(prices,"Product prices are not displayed");
    }

    @Test
    public void addToCartTest() {
        mensPage.clickAddToCart();
        // Add logic to verify the cart update if required
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}


