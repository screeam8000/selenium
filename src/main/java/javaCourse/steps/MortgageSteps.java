package javaCourse.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import javaCourse.pages.MortgagePage;
import org.junit.Assert;
import javaCourse.reporter.AllureReporter;

public class MortgageSteps {

    private MortgagePage mortgagePage = new MortgagePage();

    private void fillSelectField(String name, String value) throws Exception {
        mortgagePage.fillSelectField(name, value);
    }


    @Then("^проверить что есть заголовок Ипотечный калькулятор$")
    public void checkActiveButtonSend() {
//    AllureReporter.takeScreenshot();
        Assert.assertEquals("Ипотечный калькулятор", mortgagePage.headerText.getText());
            }


    @Then ("^заполнить данные по ипотечной заявке$")
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
}}
