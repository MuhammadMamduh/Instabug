package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage
{
    protected WebDriver driver;

    public BasePage (WebDriver driver)
    {
        this.driver= driver;
    }

    public WebElement extractElement(By elementBy)
    {
        return driver.findElement(elementBy);
    }

    public List<WebElement> extractList(By elementBy)
    {
        return driver.findElements(elementBy);
    }
}
