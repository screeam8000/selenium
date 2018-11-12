import junit.framework.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DepositTest extends BaseTest {

    @Test
    public void testDeposit(){
        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();

    }

    private void acceptRegion (){
        click(getDriver().findElement(By.xpath("//*[text()='Да']")));
    }

    @Test
    public void depositTest (){
        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();
        click(driver.findElement(By.xpath("//li/a[text()='Вклады']")));
        click(driver.findElement(By.xpath("//div/a[text()='Накопительные счета']")));
        click(driver.findElement(By.xpath("//p[contains(text(),'На каждый день')]/ancestor::div")));
        click(driver.findElement(By.xpath("//a[text()='Оставить заявку'][@class='button']")));

        org.junit.Assert.assertEquals("На каждый день", driver.findElement(By.xpath("")));

    }

}
