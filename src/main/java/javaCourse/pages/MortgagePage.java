package javaCourse.pages;

import javaCourse.annotation.FieldName;
import javaCourse.util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class MortgagePage extends BasePageObject {



    @FindBy(xpath = "//h1")
    public WebElement headerText;

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

//    @FieldName(name = "")
//    @FindBy(xpath = "")
//    public WebElement
//
//    @FieldName(name = "")
//    @FindBy(xpath = "")
//    public WebElement
//
//    @FieldName(name = "")
//    @FindBy(xpath = "")
//    public WebElement


    public void fillSelectField(String name, String value) throws Exception {
        WebElement element = getField(name);
        String atr = element.getAttribute("aria-owns");
        System.out.println(atr);
        sleep(4000);
        element.findElement(By.xpath("./parent::div/span")).click();
        WebElement elementValue = DriverManager.getDriver().findElement(By.xpath("//*[@id='" + atr +
                "']/li/div[contains(text(),'" + value + "')]"));
        elementValue.click();

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

