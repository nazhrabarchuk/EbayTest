package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTest extends BaseTest {

    private static final String EXPECTED_URL_CHANGED_COUNTRY = "https://ru.ebay.com/";

    @Test(priority = 10)
    public void checkChangeLanguage() {
        getHomePage().clickChangeCountrySiteButton();
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getHomePage().getChooseCountryItemElement());
        getBasePage().waitForPageReadyState(30);
        Assert.assertEquals(getDriver().getCurrentUrl(), EXPECTED_URL_CHANGED_COUNTRY);
    }

}
