package javaCourse.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class BasePageObject {

    public void checkText(WebElement element, String text){
        Assert.assertEquals(element.getText(), text);

    }
}
