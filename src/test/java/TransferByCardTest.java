import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TransferByCardTest extends BaseTest{

    @Test
    public void testTransfer(){

        HashMap<String, String> testData = new HashMap<>();
        testData.put("Карта отправителя", "5406 5715 1819 4617");
        testData.put("Карта получателя", "5367433138590699");
        testData.put("Срок действия", "");
        testData.put("CVC2", "512");
        testData.put("Сумма", "5");

        WebDriver driver = getDriver();
        driver.get("https://www.raiffeisen.ru/");
        acceptRegion();

        click(driver.findElement(By.xpath("//li/a[contains(text(), 'Сервисы')]")));
        click(driver.findElement(By.xpath("//div[contains(text(), 'Самообслуживание')]/following::a[1]")));

        Assert.assertEquals("Перевод с карты на карту / по номеру телефона",
                driver.findElement(By.xpath("//h1")).getText());

        fillField(driver.findElement(By.xpath("//input[@placeholder='Номер карты отправителя']")), testData.get("Карта отправителя"));
        fillField(driver.findElement(By.xpath("//input[@placeholder='Номер карты получателя']")), testData.get("Карта получателя"));
        fillField(driver.findElement(By.xpath("//input[@placeholder='CVC2']")), testData.get("CVC2"));
        fillField(driver.findElement(By.xpath("//input[@placeholder='Сумма перевода, \u20BD']")), testData.get("Сумма"));


        Assert.assertEquals("Минимальная сумма перевода – 10 р.",
                driver.findElement(By.xpath("//input[@placeholder='Сумма перевода, \u20BD']/following::div[3]")).getText());

    }

    private void acceptRegion (){
        click(getDriver().findElement(By.xpath("//*[text()='Да']")));
    }
}
