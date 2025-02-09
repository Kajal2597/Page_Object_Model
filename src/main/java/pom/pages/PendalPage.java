package pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.TestBase;

import java.util.List;
import java.util.stream.Collectors;

public class PendalPage extends TestBase {

    // Locators for the Pendants Page
    @FindBy(xpath = "//a[@id='wishlist-icon-bubble']//div[@class='header_icon_with_text']//*[name()='svg']")
    WebElement viewAllProducts;

    @FindBy(xpath = "//a[@id='CardLink-template--16317651189922__product-grid-6690308980898']")
    List<WebElement> productPrices;

    @FindBy(xpath = "//button[@id='ProductSubmitButton-quick-add-template--16317651189922__product-grid6690308980898-submit']")
    WebElement addToCartButton;

    // Constructor
    public PendalPage() {
        PageFactory.initElements(driver, this);
    }

    // Method 1: Verify URL of the page
    public String verifyPendalPageUrl() {
        return driver.getCurrentUrl();
    }

    // Method 2: Verify title of the page
    public String verifyPedalPageTitle() {
        return driver.getTitle();
    }

    // Method 3: Click "View All Products" button
    public void clickViewAllProducts() {
        viewAllProducts.click();
    }
    // Method 4: Get all product prices
    public List<String> getAllProductPrices() {
        return productPrices.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // Method 5: Add a product to the cart
    public void clickAddToCart() {
        addToCartButton.click();
    }


}
