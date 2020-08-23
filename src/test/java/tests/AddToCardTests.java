package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddToCardTests extends BaseTest {

    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "1";
    private static final String EXPECTED_PRICE_ELEMENT_WITH_COUNT_TWO = "EUR 519.90";

    @Test(priority = 7)
    public void checkAddToCard() {
        getCurrentPage();

        JavascriptExecutor executorGame = (JavascriptExecutor) getDriver();
        executorGame.executeScript("arguments[0].click();", getVideoGamesConsolePage().getVideoGameConsoleElement());
        getBasePage().waitForElementVisibility(30, getProductItemPage().getAddToCartButton());

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getProductItemPage().getAddToCartButton());
        getBasePage().waitForElementVisibility(30, getHomePage().getAmountOfProductsInCartElement());
        assertEquals(getHomePage().getAmountOfProductsInCartText(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);

    }

    @Test(priority = 8)
    public void checkRemoveElementFromCart() {
        getCurrentPage();

        JavascriptExecutor executorGame = (JavascriptExecutor) getDriver();
        executorGame.executeScript("arguments[0].click();", getVideoGamesConsolePage().getVideoGameConsoleElement());
        getBasePage().waitForElementVisibility(30, getProductItemPage().getAddToCartButton());
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getProductItemPage().getAddToCartButton());
        getHomePage().clickCartButton();
        getBasePage().waitForPageReadyState(30);
        getProductItemPage().clickCatRemoveItem();
        getBasePage().waitForElementVisibility(30, getProductItemPage().getEmptyCart());
        Assert.assertNotNull(getProductItemPage().getEmptyCart());
    }

    @Test(priority = 9)
    public void checkChangePriceItemIfChangedCountForCurrentItem() {
        getCurrentPage();

        JavascriptExecutor executorGame = (JavascriptExecutor) getDriver();
        executorGame.executeScript("arguments[0].click();", getVideoGamesConsolePage().getVideoGameConsoleElement());
        getBasePage().waitForElementVisibility(30, getProductItemPage().getAddToCartButton());
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", getProductItemPage().getAddToCartButton());
        getHomePage().clickCartButton();
        getBasePage().waitForPageReadyState(30);
        getProductItemPage().clickQuantityOfElementSelect();
        getProductItemPage().clickQuantityOfElementOptions();
        getBasePage().waitForPageReadyState(30);
        getBasePage().waitForElementVisibility(30, getProductItemPage().getElementPriceCountTwice());
        assertEquals(getProductItemPage().getElementPriceCountTwiceText(), EXPECTED_PRICE_ELEMENT_WITH_COUNT_TWO);

    }

    private void getCurrentPage(){
        getHomePage().clickElectronicButton();
        getElectronicsPage().clickVideoGamesCategoryButton();
        getElectronicsPage().clickVideoGamesConsoleButton();
        getBasePage().waitForPageReadyState(30);
    }

}
