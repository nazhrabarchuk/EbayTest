package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class SearchTests extends BaseTest {


    private static final String SEARCH_KEYWORD = "AirPods";
    private static final int EXPECTED_PRODUCT_AMOUNT = 60;
    private static final int EXPECTED_COUNT_ELEMENTS_IN_SEARCH_PAGE = 34;

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD);
        assertTrue(getDriver().getCurrentUrl().contains(SEARCH_KEYWORD));
    }

    @Test(priority = 2)
    public void checkElementsAmountOnSearchPage() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD);
        getBasePage().implicitlyWait(30);
        int actualElementsSize = getSearchResultPage().getProductList().size();
        Assert.assertEquals(actualElementsSize, EXPECTED_PRODUCT_AMOUNT);
    }

    @Test(priority = 3)
    public void checkListItemsMagnificationOnPage() {
        getHomePage().searchByKeyWord(SEARCH_KEYWORD);
        getBasePage().waitForPageReadyState(30);

        getSearchResultPage().clickItemsPerPageButton();
        WebElement element = getSearchResultPage().getCountItemsPerPageButton();
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", element);

        getBasePage().waitForElementsListVisibility(10, getSearchResultPage().getSearchedElements(), EXPECTED_COUNT_ELEMENTS_IN_SEARCH_PAGE);
        List<WebElement> elementList = getSearchResultPage().getProductList();

        int actualElementsSize = elementList.size();
        assertEquals(actualElementsSize, EXPECTED_COUNT_ELEMENTS_IN_SEARCH_PAGE);

    }
}
