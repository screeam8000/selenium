import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class InsuranceTest extends BaseTest {

    @Test
    public void testTransfer() {

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Фамилия", "Сидоров");
        testData.put("Имя", "Иван");
        testData.put("Отчество", "Сергеевич");
        testData.put("Дата рождения", "13081991");
        testData.put("Номер телефона", "999 999 99 99");
        testData.put("Эл. почта", "123@mail.ru");
        testData.put("Проверочный код", "5");

        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();

        click(driver.findElement(By.xpath("//li/a[contains(text(), 'Страхование')]")));
        click(driver.findElement(By.xpath("//a[@href='/retail/insurance/everyday/travel/vbc/']")));
        click(driver.findElement(By.xpath("//div[@class='b-intro__container']//a[@class='button']")));

        Assert.assertEquals("Форма заявки на страховую программу",
                driver.findElement(By.xpath("//h1")).getText());
        Assert.assertEquals("Вояж (Комфорт/Бизнес класс/Первый класс)",
                driver.findElement(By.xpath("//div[text()='Продукт']/preceding::span[1]")).getText());


        fillField(driver.findElement(By.xpath("//input[@placeholder='Фамилия']")), testData.get("Фамилия"));
        fillField(driver.findElement(By.xpath("//input[@placeholder='Имя']")), testData.get("Имя"));
        fillField(driver.findElement(By.xpath("//input[@placeholder='Отчество']")), testData.get("Отчество"));
        fillField(driver.findElement(By.xpath("//input[@sys_name='birth_date']")), testData.get("Дата рождения"));

        fillField(driver.findElement(By.xpath("//input[@sys_name='phone']")), testData.get("Номер телефона"));
        fillField(driver.findElement(By.xpath("//input[@placeholder='Электронная почта']")), testData.get("Эл. почта"));

        click(driver.findElement(By.xpath("//span[@class= 'checkbox-block__span']")));

        fillField(driver.findElement(By.xpath("//input[@placeholder='Проверочный код']")), testData.get("Проверочный код"));

        Assert.assertEquals(null,
                driver.findElement(By.xpath("//button[@type='submit']")).getAttribute("disabled"));

    }

    private void acceptRegion() {
        click(getDriver().findElement(By.xpath("//*[text()='Да']")));
    }
}
