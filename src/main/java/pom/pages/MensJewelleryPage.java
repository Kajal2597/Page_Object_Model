package pom.pages;

import org.openqa.selenium.support.PageFactory;
import pom.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.TestBase;

import java.util.List;
import java.util.stream.Collectors;

public class MensJewelleryPage extends TestBase {


    @FindBy(xpath = "//a[@id='wishlist-icon-bubble']//div[@class='header_icon_with_text']//*[name()='svg']//*[name()='path' and @id='wishlist_icon']")
    WebElement viewAllProducts;

    @FindBy(xpath = "//a[@id='CardLink-template--16317651189922__product-grid-8194297692322']")
    List<WebElement> productPrices;

    @FindBy(xpath = "//button[@id='ProductSubmitButton-quick-add-template--16317651189922__product-grid8194297692322-submit']")
    WebElement addToCartButton;

        public MensJewelleryPage() {

            PageFactory.initElements(driver, this);
        }
    public String verifyMensPageUrl(){
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String verifyMensPageTitle(){

        return driver.getTitle();
    }
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

