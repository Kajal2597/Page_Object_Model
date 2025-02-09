package pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.TestBase;


public class LoginPage extends TestBase
{

    //Page Factory - OR:
    @FindBy(name="customer[email]")
    WebElement username;

    @FindBy(name="customer[password]")
    WebElement password;

    @FindBy(id="login")
    public WebElement loginBtn;

    @FindBy(xpath = "//img[@alt='GIVA Jewellery']")
    private WebElement logo;

    @FindBy(id= "create-account")
    WebElement signup;

    //Initializing the Page Objects:
    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(TestBase.driver, this);//This pointing to current object
        //initialize element with driver
    }

    //Actions:
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public String verifyLoginPageUrl() {
        return driver.getCurrentUrl();
    }

    public String verifyCurrentPageUrl()
    {
        return driver.getCurrentUrl();
    }

    public String getWindowhandleid() {
        return driver.getWindowHandle();
    }


    public HomePage login(String un, String pwd){
       // ExtentTest test=extent.createTest("login");
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", loginBtn);

        return new HomePage();
    }
    public  HomePage MultiLogin (String un, String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
        return new HomePage();
}

    public HomePage viewHomePage()
    {
        logo.click();
        return new HomePage();

    }



}