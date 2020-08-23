package tests;

import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FilterTests extends BaseTest {

    private static final String EXPECTED_MIN_PRICE_VALUE = "1";
    private static final String EXPECTED_MAX_PRICE_VALUE = "200";
    private static final String WRONG_NEGATIVE_PRICE_VALUE = "-1";

    @Test(priority = 4)
    public void checkFilterByLowestPrice() {
        getHomePage().clickElectronicButton();
        getElectronicsPage().clickVideoGamesCategoryButton();
        getBasePage().waitForPageReadyState(30);
        getElectronicsPage().clickVideoGamesConsoleButton();
        getBasePage().waitForPageReadyState(30);

        WebElement element = getVideoGamesConsolePage().getSortButton();
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

        WebElement sortLowestPrice = getVideoGamesConsolePage().getSortByLowestPriceButton();
        JavascriptExecutor sortExecutor = (JavascriptExecutor) getDriver();
        sortExecutor.executeScript("arguments[0].click();", sortLowestPrice);
        getBasePage().waitForPageReadyState(30);

        List<Double> elementPriceList = getVideoGamesConsolePage().getPriceVideoGamesConsoleElements()
                .stream()
                .map(WebElement::getText)
                .map(Pattern.compile("\\d+.\\d+")::matcher)
                .map(matcher -> matcher.find() ? Double.parseDouble(matcher.group()) : 0)
                .collect(Collectors.toList());
        Assert.assertTrue(Ordering.natural().isOrdered(elementPriceList));

    }

    @Test(priority = 5)
    public void checkIfElementsPriceInRangeOfFilteredPrice() {
        getHomePage().clickElectronicButton();
        getElectronicsPage().clickVideoGamesCategoryButton();
        getBasePage().waitForPageReadyState(30);
        getElectronicsPage().clickVideoGamesConsoleButton();
        getBasePage().waitForPageReadyState(30);

        getVideoGamesConsolePage().getMinValuePriceInput().sendKeys(EXPECTED_MIN_PRICE_VALUE);
        getVideoGamesConsolePage().getMaxValuePriceInput().sendKeys(EXPECTED_MAX_PRICE_VALUE);

        WebElement submitPriceButton = getVideoGamesConsolePage().getSubmitPriceRangeButton();
        JavascriptExecutor sortExecutor = (JavascriptExecutor) getDriver();
        sortExecutor.executeScript("arguments[0].click();", submitPriceButton);
        getBasePage().waitForPageReadyState(30);

        boolean isInRange = getVideoGamesConsolePage().getPriceVideoGamesConsoleElements()
                .stream()
                .map(WebElement::getText)
                .map(Pattern.compile("\\d+.\\d+")::matcher)
                .map(matcher -> matcher.find() ? Double.parseDouble(matcher.group()) : 0)
                .allMatch(price -> price >= Double.parseDouble(EXPECTED_MIN_PRICE_VALUE) && price <= Double.parseDouble(EXPECTED_MAX_PRICE_VALUE));
        Assert.assertTrue(isInRange);

    }

    @Test(priority = 6)
    public void checkFilterRangePriceFailsIfEnteredNegativeNumber() {
        getHomePage().clickElectronicButton();
        getElectronicsPage().clickVideoGamesCategoryButton();
        getBasePage().waitForPageReadyState(30);
        getElectronicsPage().clickVideoGamesConsoleButton();
        getBasePage().waitForPageReadyState(30);

        getVideoGamesConsolePage().getMinValuePriceInput().sendKeys(WRONG_NEGATIVE_PRICE_VALUE);
        getVideoGamesConsolePage().getMaxValuePriceInput().sendKeys(EXPECTED_MAX_PRICE_VALUE);

        WebElement submitPriceButton = getVideoGamesConsolePage().getSubmitPriceRangeButton();
        JavascriptExecutor sortExecutor = (JavascriptExecutor) getDriver();
        sortExecutor.executeScript("arguments[0].click();", submitPriceButton);

        getBasePage().waitForElementVisibility(30, getVideoGamesConsolePage().getInvalidPriceRangeElement());

        Assert.assertNotNull(getVideoGamesConsolePage().getInvalidPriceRangeElement());

    }

}
