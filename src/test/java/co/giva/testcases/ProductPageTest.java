package co.giva.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.base.TestBase;
import pom.pages.HomePage;
import pom.pages.LoginPage;
import pom.pages.ProductPage;

public class ProductPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;

    public ProductPageTest(){
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
        Thread.sleep(5000);
    }

    @Test
    public void viewAllProducts() throws InterruptedException{
     //   logger.info("Product page Test Method Running");

        Thread.sleep(2000);
        productPage = homePage.viewRingPage();
        Thread.sleep(5000);
    }
    @Test
    public void verifyRingsPageUrlTest() {
        String url = productPage.verifyRingsPageUrl();
        Assert.assertEquals(url, "https://www.giva.co/collections/rings", "URL mismatch");
    }

    @Test
    public void verifyRingsPageTitleTest() {
        String title = productPage.verifyRingsPageTitle();
        Assert.assertTrue(title.contains("Rings"), "Page title mismatch");
    }

    @Test
    public void clickViewAllProductsTest() {
        productPage.clickViewAllProducts();
        Assert.assertTrue(driver.getCurrentUrl().contains("rings"), "Failed to navigate to 'View All Products'");
    }
    @Test
    public void addToCartTest() {
        productPage.clickAddToCart();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
