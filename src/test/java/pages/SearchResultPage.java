package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//ul[@class='srp-results srp-list clearfix']/li/div[@class='s-item__wrapper clearfix']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class='s-pagination']//span[@class='fake-menu-button']/button")
    private WebElement itemsPerPageButton;

    @FindBy(xpath = "//span[@class='fake-menu-button__menu fake-menu-button__menu--reverse']//a[@class='fake-menu-button__item' and contains(@href, '=25')]")
    private WebElement countItemsPerPageButton;

    private By searchedElements = By.xpath("//ul[@class='srp-results srp-list clearfix']/li/div[@class='s-item__wrapper clearfix']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public By getSearchedElements() {
        return searchedElements;
    }

    public List<WebElement> getProductList() {
        return productList;
    }

    public void clickItemsPerPageButton() {
        itemsPerPageButton.click();
    }

    public WebElement getCountItemsPerPageButton() {
        return countItemsPerPageButton;
    }

}
