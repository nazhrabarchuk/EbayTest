package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductItemPage extends BasePage {

    @FindBy(xpath = "//a[@id='tab-panel-2-w5-w0-atcBtn']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(@data-test-id, 'cart-remove-item')]")
    private WebElement catRemoveItem;

    @FindBy(xpath = "//div[@class='empty-cart']")
    private WebElement emptyCart;

    @FindBy(xpath = "//div[@class='grid__cell--one-half quantity-col']/div[@class='quantity']//select")
    private WebElement quantityOfElementSelect;

    @FindBy(xpath = "//div[@class='grid__cell--one-half quantity-col']/div[@class='quantity']//select/option[@value='2']")
    private WebElement quantityOfElementOptions;

    @FindBy(xpath = "//div[@class='price-details']/div[@class='item-price']//span[contains(text(), 'EUR 519.90')]")
    private WebElement elementPriceCountTwice;


    public ProductItemPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void clickCatRemoveItem() {
        catRemoveItem.click();
    }

    public WebElement getEmptyCart() {
        return emptyCart;
    }

    public void clickQuantityOfElementSelect() {
        quantityOfElementSelect.click();
    }

    public void clickQuantityOfElementOptions() {
         quantityOfElementOptions.click();
    }

    public String getElementPriceCountTwiceText() {
        return elementPriceCountTwice.getText();
    }
    public WebElement getElementPriceCountTwice(){
        return elementPriceCountTwice;
    }


}
