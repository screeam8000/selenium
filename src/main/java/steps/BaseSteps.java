package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.DriverManager;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void startScenario() {
        WebDriver driver = DriverManager.getDriver();
        driver.get(properties.getProperty("app.url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty("implicitlyWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(properties.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);

//        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @After
    public void afterMethod() {
        DriverManager.quitDriver();
    }

    @Then ("^Скролл в конец страницы$")
    public void scrollToBottomPage() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}
