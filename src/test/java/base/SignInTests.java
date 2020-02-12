package base;

import PageObjects.SearchPage;
import org.testng.annotations.Test;

public class SignInTests extends BaseTests
{
    @Test
    public void login()
    {
        SearchPage searchPage = new SearchPage(driver);

        searchPage
        .openSignInPage()
        .enterEmailOrPhone("three.penguins.sc@gmail.com")
        .clickNext()
        .enterPassword("learn.level_up@sc")
        .clickNext()
        ;
    }
}
