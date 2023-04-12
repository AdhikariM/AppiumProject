import AppiumUtil.AppiumConfiguration;
import PageObjects.AlertViews;
import org.testng.annotations.Test;

public class VerifyHomePage extends AppiumConfiguration {

    @Test
    public void clickAlertView(){
       AlertViews alertViews = homepage.clickAlertViews();
       alertViews.fillTextBox("Hello");

    }
}
