package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

import java.util.List;

import static Utils.Utils.removeHiddenElementsFromListOfWebElements;

public class SearchPage extends BasePage
{
    // Instance Variables
    private By signIn_btn = By.linkText("Sign in");
    private By changeLanguage_link = By.xpath("//*[@id=\"SIvCob\"]/a");
    private By search_txtField = By.xpath("//*[@title='Search' and @name='q']");
    private By googleSearch_btn = By.xpath("//*[@value='Google Search']");
    // Instance Variables
    private By searchType_navBar = By.xpath("//*[@id=\"top_nav\"]");
    private By numberOfResults = By.xpath("//*[@id=\"resultStats\"]");
    private By searchSuggestion_list = By.xpath("//*[@class=\"erkvQe\"]/li");
    private By searchResultsLink_list = By.xpath("//*[@class=\"r\"]/a/h3");
    private By imagesTab = By.linkText("Images");
    private By mapsTab = By.linkText("Maps");
    private By newsTab = By.linkText("News");
    private By videosTab = By.linkText("Videos");
    private By resultingPictures_list = By.xpath("//*[@class=\"isv-r PNCib MSM1fd BUooTd\"]");

    // Constructor
    public SearchPage(WebDriver driver)
    {
        super(driver);
    }

    // Getters
    public WebElement getSignIn_btn() {
        return extractElement(signIn_btn);
    }
    public WebElement getChangeLanguage_link() {
        return extractElement(changeLanguage_link);
    }
    public WebElement getSearch_txtField() {
        return extractElement(search_txtField);
    }
    public WebElement getGoogleSearch_btn() {
        return extractElement(googleSearch_btn);
    }
    // Getters
    public WebElement getSearchType_navBar() {
        return extractElement(searchType_navBar);
    }
    public WebElement getNumberOfResults() {
        return extractElement(numberOfResults);
    }
    public WebElement getSearchSuggestion_list() {
        return extractElement(searchSuggestion_list);
    }
    public WebElement getSearchResultsLink_list() {
        return extractElement(searchResultsLink_list);
    }
    public WebElement getImagesTab() {
        return extractElement(imagesTab);
    }

    public WebElement getMapsTab() {
        return extractElement(mapsTab);
    }

    public WebElement getNewsTab() {
        return extractElement(newsTab);
    }

    public WebElement getVideosTab() {
        return extractElement(videosTab);
    }
    public List<WebElement> getResultingPicturesList()
    {
        return extractList(resultingPictures_list);
    }

    // Functions
    public SearchPage changeLanguage()
    {
        driver.findElement(changeLanguage_link).click();

        return this;
    }
    public SearchPage enterSearchToken(String searchToken)
    {
        extractElement(search_txtField).clear();
        extractElement(search_txtField).sendKeys(searchToken);

        return this;
    }
    public SignInPage openSignInPage()
    {
        driver.findElement(signIn_btn).click();

        return new SignInPage(driver);
    }

    public List<WebElement> getTheListOfSuggestedItems()
    {
        List<WebElement> searchItems= driver.findElements(searchSuggestion_list);

        return searchItems;
    }
    public List<WebElement> getTheListOfLinkResults()
    {
        List<WebElement> linkResults= driver.findElements(searchResultsLink_list);
        removeHiddenElementsFromListOfWebElements(linkResults);

        return linkResults;
    }
    public SearchPage searchType(String tabName)
    {
        driver.findElement(By.linkText(tabName)).click();

        return this;
    }
    public GoogleMapsPage searchOnMap()
    {
        getMapsTab().click();

        return new GoogleMapsPage(driver);
    }

    // Composite Functions
    public SearchPage search(String searchToken)
    {
        enterSearchToken(searchToken);
        extractElement(search_txtField).sendKeys(Keys.ENTER);

        return this;
    }


}
