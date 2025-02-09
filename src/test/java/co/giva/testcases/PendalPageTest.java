package co.giva.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.base.TestBase;
import pom.pages.HomePage;
import pom.pages.LoginPage;
import pom.pages.PendalPage;

public class PendalPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    PendalPage pendal;

    public PendalPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp()  throws InterruptedException{
        initialization();
        Thread.sleep(5000);
        // testUtil =new TestUtil();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        homePage.viewHomePage();
       pendal= homePage.viewpendal();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void viewAllProducts() throws InterruptedException{
      //  logger.info("Pendal page Test Method Running");

        Thread.sleep(2000);
        homePage.viewpendal();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void verifyPendalPageUrlTest() {
        String url = pendal.verifyPendalPageUrl();
        Assert.assertEquals(url, "https://www.giva.co/collections/pendants", "URL mismatch");
    }

    @Test(priority = 2)
    public void verifyPendalPageTitleTest() {
        String title = pendal.verifyPedalPageTitle();
        Assert.assertEquals(title, "Buy Gold,Silver and Diamond Pendants Online at Best Price – GIVA Jewellery");
    }


    @Test(enabled = false )
    public void clickViewAllProductsTest() {
        pendal.clickViewAllProducts();
        Assert.assertTrue(driver.getCurrentUrl().contains("pendants"), "Failed to navigate to 'View All Products'");
    }
    @Test(priority = 4)
    public void addToCartTest()
    {
        pendal.clickAddToCart();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
