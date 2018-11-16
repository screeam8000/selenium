import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class CheckRegionTest extends BaseTest {

    @Test
    public void testRegion() {

        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();

//        click(driver.findElement(By.cssSelector("#icon-house")));
        click(driver.findElement(By.xpath("//a[@class='region-list__city' and contains(text(), 'Владимир')]")));

        Assert.assertEquals("МОСКВА",
                driver.findElement(By.xpath("//a[@class='sec-menu__link sm-i region-active']")).getText());

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Assert.assertEquals("Карьера в банке",
                driver.findElement(By.xpath("//a[@href='https://career.raiffeisen.ru/']")).getText());
        Assert.assertEquals("Реквизиты",
                driver.findElement(By.xpath("//a[@href='/about/requisites/']")).getText());
        Assert.assertEquals("Качество обслуживания",
                driver.findElement(By.xpath("//a[@href='/retail/servicequality/']")).getText());
        Assert.assertEquals("Противодействие коррупции",
                driver.findElement(By.xpath("//a[@href='/about/anticorr/']")).getText());
    }

    private void acceptRegion() {
        click(getDriver().findElement(By.xpath("//*[text()='Нет']")));
    }
}
