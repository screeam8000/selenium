import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LessonTest extends BaseTest {

    @Test
    public void testMethod(){
        WebDriver driver = getDriver();
        driver.get("https://online.raiffeisen.ru/demo");

        click(driver.findElement(By.xpath("")));
        click(driver.findElement(By.xpath("")));
        click(driver.findElement(By.xpath("")));

        selectInput(driver.findElement(By.xpath("")), "");
        click(driver.findElement(By.xpath("")));
        fillField(driver.findElement(By.xpath("")),"");

        Assert.assertEquals("",
                driver.findElement(By.xpath("")).getText());

        fillField(driver.findElement(By.xpath("")), "");

        Assert.assertEquals("",
                driver.findElement(By.xpath("")));

        fillField(driver.findElement(By.xpath("")), "");

        fillField(driver.findElement(By.xpath("")), "");

        click(driver.findElement(By.xpath("")));

        Assert.assertEquals("7910", driver.findElement(By.xpath("")));
        Assert.assertEquals("Сидоров", driver.findElement(By.xpath("")));
        Assert.assertEquals("100,00", driver.findElement(By.xpath("")));
        Assert.assertEquals("Комиссия", driver.findElement(By.xpath("")));
    }
}
