import AppiumUtil.AppiumConfiguration;
import PageObjects.AlertViews;
import PageObjects.StackViews;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class VerifyHomePage extends AppiumConfiguration {

    @Test
    public void clickAlertView(){
       AlertViews alertViews = homepage.clickAlertViews();
       alertViews.verifyPage();
       alertViews.fillTextBox("Hello");
       String actualMessage = alertViews.getConfirmMessage();
       AssertJUnit.assertEquals(actualMessage, "A message should be a short, complete sentence.");
       alertViews.navigateToHome();

    }


    @Test
    public void clickStackView(){
        StackViews stackViews = homepage.clickStackViews();
        stackViews.verifyStackViews();

    }


}


