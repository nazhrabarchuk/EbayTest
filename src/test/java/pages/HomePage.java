package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.Key;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchInput;

    @FindBy(xpath = "//ul[@class='hl-cat-nav__container']/li/a[contains(text(),'Electronics')]")
    private WebElement electronicsButton;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//a[contains(@class,'gh-eb-li-a')]")
    private WebElement cartButton;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//a/i[@id='gh-cart-n']")
    private WebElement amountOfProductsInCartText;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//a/i[@id='gh-cart-n']")
    private WebElement amountOfProductsInCartElement;

    @FindBy(xpath = "//a[@id='gf-fbtn']")
    private WebElement changeCountrySiteButton;

    @FindBy(xpath = "//div[@id='gf-f']/ul[@class='gf-ful']//a[@aria-label='eBay Russia']")
    private WebElement chooseCountryItemElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyWord(String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
    }

    public void clickElectronicButton() {
        electronicsButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public String getAmountOfProductsInCartText() {
        return amountOfProductsInCartText.getText();
    }

    public WebElement getAmountOfProductsInCartElement() {
        return amountOfProductsInCartElement;
    }

    public void clickChangeCountrySiteButton() {
        changeCountrySiteButton.click();
    }

    public WebElement getChooseCountryItemElement() {
        return chooseCountryItemElement;
    }


}
