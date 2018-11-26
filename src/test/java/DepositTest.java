import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;

public class DepositTest extends BaseTest {

    @Test
    public void testDeposit() {
        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();
    }

    private void acceptRegion() {
        click(getDriver().findElement(By.xpath("//*[text()='Да']")));
    }

    @Test
    public void depositTest() {

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия", "Иванов");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Иванович");
        testData.put("Дата рождения", "12121992");
        testData.put("Телефон", "9101234567");
        testData.put("Город", "Москва");
        testData.put("Отделение", "732, дополнительный офис «Отделение «Бескудниково»");

        HashMap<String, String> testCheckData = new HashMap<>();
        testCheckData.put("Дата рождения", "12.12.1992");
        testCheckData.put("Телефон", "+7 (910) 123-45-67");


        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();
        click(driver.findElement(By.xpath("//li/a[text()='Вклады']")));
        click(driver.findElement(By.xpath("//div/a[text()='Накопительные счета']")));
//        click(driver.findElement(By.xpath("//p[contains(text(),'На каждый день')]/ancestor::div")));
        scrollAndClick(driver.findElement(By.xpath("//p[contains(text(),'На каждый день')]/ancestor::div[@class='b-card__content']//*[text()='Открыть счет']")));
//        click(driver.findElement(By.xpath("//a[text()='Оставить заявку'][@class='button']")));

//        org.junit.Assert.assertEquals("На каждый день", driver.findElement(By.xpath("")));
        Assert.assertEquals("На каждый день", driver.findElement(By.xpath("//*[text()='Накопительный счет']/parent::div/div")).getText());

//        click(driver.findElement(By.xpath("//ul[@class='main-menu']//a[text()='Вклады']")));
//        click(driver.findElement(By.xpath("//*[text()='Накопительные счета']")));
//        click(driver.findElement(By.xpath("//a[text()='Оставить заявку'][@class='button']")));


        fillField(driver.findElement(By.xpath("//*[text()='Фамилия']/parent::div/input")), testData.get("Фамилия"));
        fillField(driver.findElement(By.xpath("//*[text()='Имя']/parent::div/input")), testData.get("Имя"));
        fillField(driver.findElement(By.xpath("//*[text()='Отчество']/parent::div/input")), testData.get("Отчество"));

        fillDate(driver.findElement(By.xpath("//*[text()='Дата рождения']/parent::div/input")), testData.get("Дата рождения"));
        fillField(driver.findElement(By.xpath("//*[text()='Телефон']/parent::div/input")), testData.get("Телефон"));

        Assert.assertEquals(testCheckData.get("Дата рождения"),
                driver.findElement(By.xpath("//*[text()='Дата рождения']/parent::div/input")).getAttribute("value"));
        Assert.assertEquals(testCheckData.get("Телефон"),
                driver.findElement(By.xpath("//*[text()='Телефон']/parent::div/input")).getAttribute("value"));

        Assert.assertTrue("Кнопка - Выслать код не активна",
                driver.findElement(By.xpath("//*[text()='Выслать код']")).isEnabled());


//        selectInput(driver.findElement(By.xpath("//*[text()='Город']/parent::div/div")), "//option[@value=170]");
        selectInput(driver.findElement(By.xpath("//*[text()='Город']/parent::div/div")),
                driver.findElement(By.xpath("//*[text()='Город']/parent::div/div/div/input")),
                testData.get("Город"));
//        sleep(7000);
        selectInput(driver.findElement(By.xpath("//*[text()='Отделение банка']/parent::div/div")),
                driver.findElement(By.xpath("//*[text()='Отделение банка']/parent::div/div/div/input")),
                testData.get("Отделение"));

        Assert.assertTrue("Не найден элмент - Осталось заполнить: Телефон",
                isElementPresent(By.xpath("//div[@class='page-item__invalid'][.//div[text()='Осталось заполнить поля:']]//span[text()='Телефон']")));
    }

    public void fillDate(WebElement element, String value) {
        element.sendKeys(value);
        element.click();
    }

}

