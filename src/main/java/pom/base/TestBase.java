package pom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.slf4j.LoggerFactory;
import pom.utils.WebEventListener;


public class TestBase {

    public static WebDriver driver;
    public static Properties prop;

    public static Logger logger = Logger.getLogger(TestBase.class);

    public ExtentReports extent=new ExtentReports();
    public ExtentSparkReporter spark =new ExtentSparkReporter("test-output/ExtentReport.html");
    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/pom"
                    + "/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(){

        logger.info("Browser name:"+prop.getProperty("browser"));
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
          //  System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");
            driver = new ChromeDriver();
            logger.info("Application url"+prop.getProperty("url1"));
        }
        else if(browserName.equals("FF")){
           // System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
            driver = new FirefoxDriver();
        }
        WebEventListener listener = new WebEventListener();
        driver = new EventFiringDecorator<>(listener).decorate(driver);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//
////        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
////        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url1"));

    }









}