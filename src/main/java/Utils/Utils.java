package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils
{
    protected WebDriver driver;
    protected JavascriptExecutor js;

    public Utils(WebDriver driver)
    {
        this.driver= driver;
    }
    // Tool
    public static List<WebElement> removeHiddenElementsFromListOfWebElements(List<WebElement> List)
    {
        for(int i= 0; i<List.size(); i++)
        {
            if(List.get(i).isDisplayed()==false)
            {
                List.remove(i);
            }
        }

        return List;
    }

    public static void scrollToElement(WebDriver driver, WebElement element)
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
