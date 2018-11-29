package javaCourse.pages;

import javaCourse.annotation.FieldName;
import javaCourse.util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class MortgagePage extends BasePageObject {


    @FindBy(xpath = "//h1")
    public WebElement headerText;

    @FindBy(xpath = "//div[@class='b-calc-result__month']//span[@class='monthly-payment']")
    @FieldName(name = "Ежемесячный платеж")
    public WebElement monthlyPay;

    @FieldName(name = "Город")
    @FindBy(xpath = "//*[contains(text(),'Город')]/parent::div/div/parent::*/span")
    public WebElement selectCity;

    @FieldName(name = "Вид ипотечной программы")
    @FindBy(xpath = "//*[contains(text(),'Вид ипотечной программы')]/parent::div/div/parent::*/span")
    public WebElement typeOfMortgage;

    @FieldName(name = "Я являюсь")
    @FindBy(xpath = "//*[contains(text(),'Я являюсь')]/parent::div/div/parent::*/span")
    public WebElement newClient;

    @FieldName(name = "Уровень доходов подтверждаю")
    @FindBy(xpath = "//*[contains(text(),'Уровень доходов подтверждаю')]/parent::div/div/parent::*/span")
    public WebElement incomeConfirm;

    @FieldName(name = "В банке возьму")
    @FindBy(xpath = "//div/input[@id='form_credit_amount']")
    public WebElement inputAmount;

    @FieldName(name = "Первоначальный взнос")
    @FindBy(xpath = "//div/input[@id='form_initial']")
    public WebElement firstPie;

    @FieldName(name = "Срок кредита")
    @FindBy(xpath = "//div/input[@id='form_period']")
    public WebElement creditTerm;

    @FieldName(name = "Знаю свою ипотечную программу")
    @FindBy(xpath = "//span[@class='checkbox-block__span']")
    public WebElement fillCheckBox;

    @FindBy(xpath = "//input[@type='button']")
    @FieldName(name = "Рассчитать")
    public WebElement clickCountButton;

    @FindBy(xpath = "//div[contains(text(), 'Общая сумма выплат')]/following::div[1]")
    @FieldName(name = "Общая сумма выплат")
    public WebElement generalSum;

    @FindBy(xpath = "//div[contains(text(), 'Cумма выплат по процентам')]/following::div[1]")
    @FieldName(name = "Cумма выплат по процентам")
    public WebElement percentSum;

    @FindBy(xpath = "//div[contains(text(), 'Процентная ставка')]/following::div[1]")
    @FieldName(name = "Процентная ставка")
    public WebElement interestRate;

    public void fillField(String name, String value) throws Exception {
        WebElement element = getField(name);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].style.border='1px solid magenta';", element);

        Actions actionList = new Actions(DriverManager.getDriver());
        actionList.doubleClick(element).
//                clickAndHold(element).sendKeys(value).
        release().build().perform();
//        element.clear();
        element.sendKeys(value);
        js.executeScript("return arguments[0].style.border='1px solid black';", element);
    }


    public void fillSelectField(String name, String value) throws Exception {
        WebElement element = getField(name);
        String atr = element.getAttribute("aria-owns");
//        System.out.println(atr);
        sleep(4000);
        element.findElement(By.xpath("./parent::div/span")).click();
        WebElement elementValue = DriverManager.getDriver().findElement(By.xpath("//*[@id='" + atr +
                "']/li/div[contains(text(),'" + value + "')]"));
        elementValue.click();

    }

    public void checkField(String name, String value) throws Exception {
        WebElement element = getField(name);
        Assert.assertEquals(value, element.getText());
    }

    public WebElement getField(String name) throws Exception {
        Class example = Class.forName("javaCourse.pages.MortgagePage");
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields) {
            if (field.getAnnotation(FieldName.class) != null
                    && field.getAnnotation(FieldName.class).name().equals(name)) {
                WebDriver webDriver = DriverManager.getDriver();
                return webDriver.findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public MortgagePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}

