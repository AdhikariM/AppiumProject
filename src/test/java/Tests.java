import AppiumUtil.AppiumConfiguration;
import PageObjects.AlertViews;
import PageObjects.PickerView;
import PageObjects.StackViews;
import PageObjects.Switches;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends AppiumConfiguration {

    @Test
    public void clickAlertView(){
        try {
            AlertViews alertViews = homepage.clickAlertViews();
            alertViews.verifyPage();
            alertViews.fillTextBox("Hello");
            String actualMessage = alertViews.getConfirmMessage();
            Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
            alertViews.navigateToHome();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to: " + e.getMessage());
        }
    }



    @Test
    public void clickStackView(){
        try {
            StackViews stackViews = homepage.clickStackViews();
            stackViews.verifyStackViews();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void clickSwitchesView(){
        Switches switches = homepage.clickSwitches();
        switches.verifyPage();
        switches.toggleSwitch();
    }

    @Test
    public void clickPickerView() {
        try {
            PickerView pickerView = new PickerView(driver);
            pickerView.colorMixer();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }
    }




}


