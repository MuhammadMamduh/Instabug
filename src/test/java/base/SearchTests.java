package base;

import PageObjects.SearchPage;
import PageObjects.SearchResultsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static Utils.Utils.scrollToElement;

public class SearchTests extends BaseTests
{
    @DataProvider
    public Object[][] searchTokensProvider()
    {
        return new Object[][]{{"Selenium"}, {"مصر"}, {"@%\",,..%!'''"}, {"       "}};
    }
    @DataProvider
    public Object[][] searchTokensProvider_forSuggestions()
    {
        return new Object[][]{{"egy"}, {"ppppfspffsasad"}};
    }

    @Test(priority = 0, dataProvider = "searchTokensProvider")
    public void simpleSearch(String searchToken)
    {
        searchPage = new SearchPage(driver);
        searchPage.search(searchToken);

        softAssert= new SoftAssert();
        softAssert.assertTrue(searchPage.getSearchType_navBar().isDisplayed(), "Passed");
        softAssert.assertTrue(searchPage.getNumberOfResults().isDisplayed(), "Passed");
        softAssert.assertAll();

        System.out.println(searchPage.getNumberOfResults().getText());
    }

    @Test(priority = 1, dataProvider = "searchTokensProvider_forSuggestions")
    public void searchSuggestions(String searchToken)
    {
        searchPage = new SearchPage(driver);
        searchPage.enterSearchToken(searchToken);

        Assert.assertNotEquals(searchPage.getTheListOfSuggestedItems().size(), 0);
        System.out.println("The number of suggested items: " + searchPage.getTheListOfSuggestedItems().size());
        for(WebElement x:searchPage.getTheListOfSuggestedItems())
        {
            System.out.println(x.getText());
        }
    }

    @Test(priority = 1)
    public void openOneOfTheResults ()
    {
        searchPage = new SearchPage(driver);
        searchPage.search("Egypt");

        String pageTitle= searchPage.getTheListOfLinkResults().get(7).getText();
        System.out.println(pageTitle);

        scrollToElement(driver, searchPage.getTheListOfLinkResults().get(6));
        try
        {
            searchPage.getTheListOfLinkResults().get(7).click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Assert.assertEquals(driver.getTitle(), pageTitle);
        driver.navigate().back();
    }

    @Test(priority = 1)
    public void openOtherSearchTabs ()
    {
        softAssert= new SoftAssert();

        searchPage = new SearchPage(driver);
        searchPage
        .search("Egypt")
        .searchType("Images")
        ;

        softAssert.assertEquals(searchPage.getResultingPicturesList().size(), 100);
        System.out.println(searchPage.getResultingPicturesList().size());

        searchPage.searchType("Videos")
        .searchType("News")
        .searchType("All")
        ;

        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void openGoogleMaps ()
    {
        searchPage = new SearchPage(driver);

        WebElement directions_btn= searchPage.search("Cairo").searchOnMap().getDirections_btn();

        Assert.assertTrue(directions_btn.isDisplayed());
        driver.navigate().back();
    }


}
