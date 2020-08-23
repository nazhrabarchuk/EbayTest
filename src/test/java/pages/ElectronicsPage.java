package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElectronicsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Video Games & Consoles')]/parent::a")
    private WebElement videoGamesCategoryButton;

    @FindBy(xpath = "//p[@class='b-guidancecard__title' and contains(text(),'Video Game Consoles')]/parent::a")
    private WebElement videoGamesConsoleButton;

    public ElectronicsPage(WebDriver driver){
        super(driver);
    }

    public void clickVideoGamesCategoryButton(){
        videoGamesCategoryButton.click();
    }

    public void clickVideoGamesConsoleButton(){
        videoGamesConsoleButton.click();
    }
}
