package javaCourse.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import javaCourse.pages.InsurancePage;
import org.junit.Assert;

public class InsuranceSteps {

    private InsurancePage insurancePage = new InsurancePage();

    private void fillField(String name, String value) throws Exception {
        insurancePage.fillField(name, value);
    }


    @Then("^переход по ссылке В путешествие$")
    public void clickTravelLink() {
        insurancePage.inTravelLink.click();

    }

    @Then("^переход по ссылке Вояж$")
    public void clickVoyage() {
        insurancePage.voyage.click();
    }

    @Then("^нажать на кнопку Оставить заявку$")
    public void pressButtonSendApp() {
        insurancePage.submitButton.click();
    }

    @Then("^заполнить данные по заявке$")
    public void fillFields(DataTable fields) throws Exception {
        fields.asMap(String.class, String.class).forEach(
                (k, v) -> {
                    try {
                        fillField(k, v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Then("^проставить чек-бокс$")
    public void fillCheckBox() {
        insurancePage.checkBox.click();
    }

    @Then("^проверить активность кнопки Отправить$")
    public void checkActiveButtonSend() {
        Assert.assertEquals(null, insurancePage.getSubmitButton.getAttribute("disabled"));
    }
}
