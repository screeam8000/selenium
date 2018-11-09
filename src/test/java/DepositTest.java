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

//        HashMap<String, String> testData = new HashMap<>();
//        testData.put("Фамилия", "Имя");
//        testData.put("Фамилия", "Имя");
//        testData.put("Фамилия", "Имя");
//        testData.put("Фамилия", "Имя");
//        testData.put("Фамилия", "Имя");
//        testData.put("Фамилия", "Имя");
//
//        HashMap<String, String> testCheckData = new HashMap<>()


    }

    private void acceptRegion (){
        click(getDriver().findElement(By.xpath("//*[text()='Да']")));
    }

    private void DepositTest (){
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
