import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriverWait wait;
    private static WebDriver driver;


    public static WebDriver getDriver(){return driver;}

    @Before
    public void startScenario(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
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

    public void selectInput(WebElement select, String value){
        select.click();
        click(select.findElement(By.xpath("" + value + "")));
    }


}
