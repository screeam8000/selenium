package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.DriverManager;


public class MainPage{

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
            public WebElement cities;


    public MainPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        //pagefactory драйвер который инцилизирует страницу что бы обратиться к элементам
    }

}
