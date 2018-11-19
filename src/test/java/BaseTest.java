import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriverWait wait;
    private static WebDriver driver;
    private static Properties properties = TestProperties.getInstance().getProperties();


    public static WebDriver getDriver(){return driver;}

    @Before
    public void startScenario(){

//        WebDriver driver = DriverManager.getDriver();

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "drv/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);

//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);


        driver.manage().window().maximize();
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

    public void click(WebElement element){wait.until(ExpectedConditions.visibilityOf(element))
    .click();}

    public void scrollAndClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return arguments[0].scrollIntoView(false);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void fillField(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
        element.sendKeys(Keys.TAB );
    }

    public void selectInput(WebElement select, WebElement select_input, String value){
        select.click();
        select_input.sendKeys(value + Keys.ENTER);
    }

    public boolean isElementPresent(By locator) {
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            return getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            getDriver().manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        }
    }
}
