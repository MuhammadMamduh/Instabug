package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage
{
    By email_txtField = By.xpath("//*[@type='email']");
    By password_txtField = By.xpath("//*[@type=\"password\" and @name=\"password\"]");
    By next_btn = By.xpath("//*[@class=\"RveJvd snByac\"]");

    public SignInPage(WebDriver driver)
    {
        super(driver);
    }

    public SignInPage enterEmailOrPhone(String emailOrPhone)
    {
        driver.findElement(email_txtField).sendKeys(emailOrPhone);

        return this;
    }

    public SignInPage enterPassword(String password)
    {
        driver.findElement(password_txtField).sendKeys(password);

        return this;
    }

    public SignInPage clickNext()
    {
        try
        {
            driver.findElement(next_btn).click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return this;
    }

}
