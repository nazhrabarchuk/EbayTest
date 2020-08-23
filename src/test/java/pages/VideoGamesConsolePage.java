package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VideoGamesConsolePage extends BasePage {

    @FindBy(xpath = "//label[@class='srp-controls__sort-label' and contains(text(), 'Sort')]/following-sibling::button")
    private WebElement sortButton;

    @FindBy(xpath = "//span[contains(text(),'Price + Shipping: lowest first')]/parent::a")
    private WebElement sortByLowestPriceButton;

    @FindBy(xpath = "//ul[contains(@class,'b-list__items_nofooter')]/li//span[@class='s-item__price']")
    private List<WebElement> priceVideoGamesConsoleElements;

    @FindBy(xpath = "//input[contains(@aria-label, 'Minimum Value')]")
    private WebElement minValuePriceInput;

    @FindBy(xpath = "//input[contains(@aria-label, 'Maximum Value')]")
    private WebElement maxValuePriceInput;

    @FindBy(xpath = "//button[contains(@aria-label, 'Submit price range')]")
    private WebElement submitPriceRangeButton;

    @FindBy(xpath = "//div[@class='x-price__error show' and contains(text(),'Please provide a valid price range')]")
    private WebElement invalidPriceRangeElement;

    @FindBy(xpath = "//a[@class='s-item__link']/h3[@class='s-item__title' and contains(text(), 'Sony PS4 Pro Console 1TB + New Controller Game Console-Playstation')]")
    private WebElement videoGameConsoleElement;

    public VideoGamesConsolePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSortButton() {
        return sortButton;
    }

    public WebElement getSortByLowestPriceButton() {
        return sortByLowestPriceButton;
    }

    public List<WebElement> getPriceVideoGamesConsoleElements() {
        return priceVideoGamesConsoleElements;
    }

    public WebElement getMinValuePriceInput() {
        return minValuePriceInput;
    }

    public WebElement getMaxValuePriceInput() {
        return maxValuePriceInput;
    }

    public WebElement getSubmitPriceRangeButton() {
        return submitPriceRangeButton;
    }

    public WebElement getInvalidPriceRangeElement() {
        return invalidPriceRangeElement;
    }

    public WebElement getVideoGameConsoleElement() {
        return videoGameConsoleElement;
    }

}
