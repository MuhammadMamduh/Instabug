package base;

import PageObjects.SearchPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseTests {
//    private EventFiringWebDriver driver;
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected SearchPage searchPage;
    protected SoftAssert softAssert;
    // The Functions are written in the order of their execution.
    // ______________________________________ [ Before ] ______________________________________
    @BeforeSuite
    public void setUp() throws InterruptedException {
        // Setup system properties
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //1 - Maximize the window
        driver.manage().window().maximize();

        //2 - Fullscreen mode
//        driver.manage().window().fullscreen();

        //3 - Specific width (iPhoneX)
        //driver.manage().window().setSize(new Dimension(375, 812));

        System.out.println(driver.getTitle());

    }
    @BeforeTest
    public void beforeTest()
    {
        // Open the browser
        searchPage = new SearchPage(driver);
        searchPage.changeLanguage();
    }
    @BeforeClass
    public void beforeClass()
    {
        // Open the test application.
    }
    @BeforeMethod
    public void beforeMethod()
    {
        // Sign in
    }
    // _______________________________________________________________________________________
    @Test
    public void test()
    {
        System.out.println("Test");
    }
    // ______________________________________ [ After ] ______________________________________
    @AfterMethod
    public void afterMethod()
    {
        // Ex: Sign out
//        driver.navigate().to("https://www.google.com/");
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        // Close the test application.
        Thread.sleep(3000);
    }
    @AfterTest
    public void afterTest()
    {
        // Close the browser window
        driver.close();
    }
    @AfterSuite
    public void tearDown()
    {
        // Clean up all cookies.
        // driver.manage().deleteAllCookies();
        driver.quit();

    }
}
