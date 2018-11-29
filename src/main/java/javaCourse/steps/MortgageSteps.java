package javaCourse.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import javaCourse.pages.MortgagePage;
import org.junit.Assert;
import javaCourse.reporter.AllureReporter;

import java.util.concurrent.TimeUnit;

public class MortgageSteps {

    private MortgagePage mortgagePage = new MortgagePage();

    private void fillSelectField(String name, String value) throws Exception {
        mortgagePage.fillSelectField(name, value);
    }

    private void fillField(String name, String value) throws Exception {
        mortgagePage.fillField(name, value);
    }


    @Then("^проверить что есть заголовок Ипотечный калькулятор$")
    public void checkActiveButtonSend() {
//    AllureReporter.takeScreenshot();
        Assert.assertEquals("Ипотечный калькулятор", mortgagePage.headerText.getText());
    }


    @Then("^заполнить данные по ипотечной заявке$")
    public void fillSelectFields(DataTable fields) throws Exception {
        fields.asMap(String.class, String.class).forEach(
                (k, v) -> {
                    try {
                        fillSelectField(k, v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Then("^заполнить следующие данные$")
    public void fillField(DataTable fields) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(3l);
        fields.asMap(String.class, String.class).forEach(
                (k, v) -> {
                    try {
                        fillField(k, v);
                        TimeUnit.SECONDS.sleep(3l);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Then("^установить чек-бокс Знаю свою ипотечную программу$")
    public void putCheckBox() throws InterruptedException {
        mortgagePage.fillCheckBox.click();
        TimeUnit.SECONDS.sleep(3l);

    }

    @Then("^нажать кнопку Рассчитать$")
    public void clickBottom() throws InterruptedException {
        mortgagePage.clickCountButton.click();
        TimeUnit.SECONDS.sleep(3l);
    }

    @And("^проверить данные$")
    public void checkMonthPay(DataTable fields) throws InterruptedException {
//        TimeUnit.SECONDS.sleep(3l);
        fields.asMap(String.class, String.class).forEach(
                (k, v) -> {
                    try {
                        mortgagePage.checkField(k, v);
                        TimeUnit.SECONDS.sleep(3l);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }


}


