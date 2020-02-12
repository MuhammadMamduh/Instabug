package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMapsPage extends BasePage
{
    By directions_btn= By.xpath("//*[@data-value=\"Directions\" and @aria-label=\"Directions\"]");

    public GoogleMapsPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement getDirections_btn()
    {
        return extractElement(directions_btn);
    }
}
