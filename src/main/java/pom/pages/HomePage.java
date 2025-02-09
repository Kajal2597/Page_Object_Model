package pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.TestBase;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends TestBase {

    // Define locators using @FindBy annotations
    @FindBy(xpath = "/html[1]/body[1]/div[2]/sticky-header[1]/header[1]/a[1]/div[1]/img[1]")
    WebElement logo;

    @FindBy(xpath = "//span[normalize-space()='Pan India Free Shipping!']")
    WebElement logoview;

    @FindBy(xpath = "//a[contains(@href, '/collections/')]")
    List<WebElement> navigationLinks;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchBox;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/sticky-header[1]/header[1]/predictive-search[1]/form[1]/div[1]/button[2]/*[name()='svg'][1]/*[name()='use'][1]")
    WebElement searchButton;

    @FindBy(xpath = "//a[@href='/collections/diamond-collection']//div[@class='slideshow__media banner__media media small-hide']")
    WebElement bestSellersLink;


    @FindBy(xpath = "//body/main[@id='MainContent']/section[@id='shopify-section-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e']/div[contains(@class,'color-background-1 gradient small-hide')]/div[contains(@class,'collection-list-wrapper page-width isolate page-width-desktop no-heading no-mobile-link section-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e-padding')]/slider-component[contains(@class,'slider-mobile-gutter scroll-trigger animate--slide-in slider-component-desktop')]/ul[@id='Slider-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e']/li[@id='Slide-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e-1']/div[contains(@class,'card-wrapper animate-arrow collection-card-wrapper')]/div[contains(@class,'card')]/div[contains(@class,'card__content')]/div[contains(@class,'card__information')]/h3[contains(@class,'card__heading')]/a[1]")
    private WebElement pendal;

    @FindBy(xpath = "//body/main[@id='MainContent']/section[@id='shopify-section-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e']/div[contains(@class,'color-background-1 gradient small-hide')]/div[contains(@class,'collection-list-wrapper page-width isolate page-width-desktop no-heading no-mobile-link section-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e-padding')]/slider-component[contains(@class,'slider-mobile-gutter scroll-trigger animate--slide-in slider-component-desktop')]/ul[@id='Slider-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e']/li[@id='Slide-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e-8']/div[contains(@class,'card-wrapper animate-arrow collection-card-wrapper')]/div[contains(@class,'card')]/div[@class='card__content']/div[@class='card__information']/h3[@class='card__heading']/a[1]")
    private WebElement mensjwel;

    @FindBy(xpath = "//body/main[@id='MainContent']/section[@id='shopify-section-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e']/div[contains(@class,'color-background-1 gradient small-hide')]/div[contains(@class,'collection-list-wrapper page-width isolate page-width-desktop no-heading no-mobile-link section-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e-padding')]/slider-component[contains(@class,'slider-mobile-gutter scroll-trigger animate--slide-in slider-component-desktop')]/ul[@id='Slider-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e']/li[@id='Slide-template--16317651484834__74c96ef5-34a6-4e6d-ac63-5fddece7442e-2']/div[contains(@class,'card-wrapper animate-arrow collection-card-wrapper')]/div[contains(@class,'card')]/div[contains(@class,'card__content')]/div[contains(@class,'card__information')]/h3[contains(@class,'card__heading')]/a[1]")
    private WebElement ring;

    // Initializing the Page Objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        System.out.println(driver.getTitle());
        return driver.getTitle();
    }

    public  ProductPage viewRingPage() {
        ring.click();
        return new ProductPage();
    }
    public HomePage viewHomePage()
    {
        logo.click();
        return new HomePage();
    }

    public PendalPage viewpendal() {
        pendal.click();
        return new PendalPage();
    }

    public MensJewelleryPage viewMensJewellery() {
        mensjwel.click();
        return new MensJewelleryPage();
    }
    // Method 1: Verify if the logo is displayed
    public boolean isLogoDisplayed() {
        return logoview.isDisplayed();
    }

    public String verifyHomePageUrl()
    {
        return driver.getCurrentUrl();
    }
    // Method 3: Perform a search operation
    public void performSearch(String query) {
        searchBox.sendKeys(query);
        searchButton.click();
    }

    // Method 4: Verify the "Best Sellers" link is clickable
    public boolean isBestSellersLinkClickable() {
        return bestSellersLink.isDisplayed() && bestSellersLink.isEnabled();
    }

    // Method 5: Get current URL after navigating to "Best Sellers"
    public String navigateToBestSellers() {
        bestSellersLink.click();
        return driver.getCurrentUrl();
    }
}
