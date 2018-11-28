package javaCourse.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import javaCourse.util.DriverManager;


public class MainPage extends BasePageObject {

    @FindBy(xpath = "//a[@class='region-list__city' and contains(text(), 'Владимир')]")
    public WebElement city;
    @FindBy(xpath = "//a[@class='sec-menu__link sm-i region-active']")
    public WebElement activeCity;
    @FindBy(xpath = "//a[@href='https://career.raiffeisen.ru/']")
    public WebElement career;
    @FindBy(xpath = "//a[@href='/about/requisites/']")
    public WebElement requisites;
    @FindBy(xpath = "//a[@href='/retail/servicequality/']")
    public WebElement servicequality;
    @FindBy(xpath = "//a[@href='/about/anticorr/']")
    public WebElement anticorr;
    @FindBy(xpath = "//*[text()='Нет']")
    public WebElement isMyCityNo;
    @FindBy(xpath = "//*[text()='Да']")
    public WebElement isMyCityYes;


    @FindBy(xpath = "//li/a[contains(text(), 'Страхование')]")
    public WebElement insuranceLink;
    @FindBy(xpath = "//li/a[contains(text(), 'Ипотека')]")
    public WebElement mortgageLink;
    @FindBy (xpath = "//a[contains(text(), 'Ипотечный калькулятор')]")
    public WebElement mortgageCalc;

    public MainPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        //pagefactory драйвер который инцилизирует страницу что бы обратиться к элементам
    }
}
