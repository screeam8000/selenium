package javaCourse.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import javaCourse.util.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import javaCourse.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class MainSteps {

    private MainPage mainPage = new MainPage();


    @Then("^Скролл в конец страницы$")
    public void scrollToBottomPage() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("^Выбор города$")
    public void cityClick() {
        mainPage.city.click();
    }

    @Given("^Выбран не мой регион$")
    public void acceptRegionNo() {
        mainPage.isMyCityNo.click();
    }

    @Given("^Выбран мой регион$")
    public void acceptRegionYes() {
        mainPage.isMyCityYes.click();
    }

    @Then("^Проверяет корректность выбранного города$")
    public void checkActiveCity() {
        mainPage.checkText(mainPage.activeCity, "ВЛАДИМИР");
    }

    @Then("^Поиск текста Карьера в банке$")
    public void checkCareerText() {
        mainPage.checkText(mainPage.career, "Карьера в банке");
    }

    @Then("^Поиск текста Реквизиты$")
    public void checkRequisitesText() {
        mainPage.checkText(mainPage.requisites, "Реквизиты");
    }

    @Then("^Поиск текста Качество обслуживания$")
    public void checkSQText() {
        mainPage.checkText(mainPage.servicequality, "Качество обслуживания");
    }

    @Then("^Поиск текста Противодействие коррупции$")
    public void checkAntiCorrText() {
        mainPage.checkText(mainPage.anticorr, "Противодействие коррупции");
    }

    @Then("^переход по ссылке Страхование$")
    public void clickInsuranceLink() throws InterruptedException {
        mainPage.insuranceLink.click();
        TimeUnit.SECONDS.sleep(3L);
    }

    @Then("^переход по ссылке Ипотека$")
    public void clickMortgageLink() throws InterruptedException {
        mainPage.mortgageLink.click();
        TimeUnit.SECONDS.sleep(3L);
    }

    @Then("^переход по ссылке Ипотечный калькулятор$")
    public void clickMortgageCalc() throws InterruptedException {
        mainPage.mortgageCalc.click();
        TimeUnit.SECONDS.sleep(3L);
    }

}
