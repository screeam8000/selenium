package steps;

import org.junit.Assert;
import pages.MainPage;

public class MainSteps extends BaseSteps{

    MainPage mainPage = new MainPage();

    public void cityClick() {
        mainPage.city.click();
    }

//    public void regionIsCompare (){
//        if (mainPage.activeCity.getText().equalsIgnoreCase("ВЛАДИМИР")) {
//            return;
//        }
//        Assert.fail();
//    }

    public void regionIsExist() {
        elementIsExistAndEqual(mainPage.activeCity, "ВЛАДИМИР");
    }


    public void careerIsExist() {
        if (mainPage.career.isDisplayed())
            return;
        Assert.fail();
    }

//    public void



}
