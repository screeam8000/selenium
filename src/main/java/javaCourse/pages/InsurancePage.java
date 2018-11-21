package javaCourse.pages;

import javaCourse.annotation.FieldName;
import javaCourse.util.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class InsurancePage extends BasePageObject {

    @FindBy(xpath = "//div[@class='b-intro__container']//a[@class='button']")
    public WebElement submitButton;

    @FindBy(xpath = "//h1")
    public WebElement headerText;

    @FindBy(xpath = "//div[text()='Продукт']/preceding::span[1]")
    public WebElement productType;

    @FindBy(xpath = "//input[@placeholder='Фамилия']")
    @FieldName(name = "Фамилия")
    public WebElement placeholderSurname;

    @FindBy(xpath = "//input[@placeholder='Имя']")
    @FieldName(name = "Имя")
    public WebElement placeholderName;

    @FindBy(xpath = "//input[@placeholder='Отчество']")
    @FieldName(name = "Отчество")
    public WebElement placeholderMiddleName;

    @FindBy(xpath = "//input[@sys_name='birth_date']")
    @FieldName(name = "Дата рождения")
    public WebElement placeholderDateBirth;

    @FindBy(xpath = "//input[@sys_name='phone']")
    @FieldName(name = "Телефон")
    public WebElement placeholderPhone;

    @FindBy(xpath = "//input[@placeholder='Электронная почта']")
    @FieldName(name = "Электронная почта")
    public WebElement placeholderMail;

    @FindBy(xpath = "//span[@class= 'checkbox-block__span']")
    public WebElement checkBox;

    @FindBy(xpath = "//input[@placeholder='Проверочный код']")
    @FieldName(name = "Проверочный код")
    public WebElement checkCode;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement getSubmitButton;

    @FindBy(xpath = "//div[text()='Продукт']/preceding::span[1]")
    public WebElement voyage;

    @FindBy(xpath = "//a[@href='/retail/insurance/everyday/travel/vbc/']")
    public WebElement inTravelLink;

    public void fillField(String name, String value) throws Exception {
        WebElement element = getField(name);
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].style.border='1px solid magenta';", element);
        element.clear();
        element.sendKeys(value);
        js.executeScript("return arguments[0].style.border='1px solid black';", element);
    }

    public WebElement getField(String name) throws Exception {
        Class example = Class.forName("javaCourse.pages.InsurancePage");
        List<Field> fields = Arrays.asList(example.getFields());
        for (Field field : fields){
            if (field.getAnnotation(FieldName.class).name().equals(name)){
                return DriverManager.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Не объявлен элемент с наименованием " + name);
        return null;
    }

    public InsurancePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        //pagefactory драйвер который инцилизирует страницу что бы обратиться к элементам
    }
}
