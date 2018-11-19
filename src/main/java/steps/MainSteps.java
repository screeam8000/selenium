package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.MainPage;

public class MainSteps extends BaseSteps {

    private MainPage mainPage = new MainPage();


    @Then ("^Выбор города$")
    public void cityClick() {
        mainPage.city.click();
    }

    @Given("^Выбор региона$")
    public void acceptRegion() {
        mainPage.cities.click();
    }

    @Then("^Проверяет корректность выбранного города$")
    public void checkActiveCity (){
        checkText(mainPage.activeCity, "ВЛАДИМИР");
    }

    @Then("^Поиск текста Карьера в банке$")
    public void checkCareerText (){
        checkText(mainPage.career, "Карьера в банке");
    }

    @Then("^Поиск текста Реквизиты$")
    public void checkRequisitesText (){
        checkText(mainPage.requisites, "Реквизиты");
    }

    @Then("^Поиск текста Качество обслуживания$")
    public void checkSQText (){
        checkText(mainPage.servicequality, "Качество обслуживания");
    }

    @Then("^Поиск текста Противодействие коррупции$")
    public void checkAntiCorrText (){
        checkText(mainPage.anticorr, "Противодействие коррупции");
    }




public void checkText (WebElement element, String text){
        Assert.assertEquals(element.getText(), text);

    }

}
