import AppiumUtil.AppiumConfiguration;
import org.testng.annotations.Test;
import PageObjects.SwitchView;

public class SwitchViewTests extends AppiumConfiguration {



    @Test
    //bug in app [java.lang.AssertionError: expected [0] but found [0]]
    public void clickSwitchesView(){
        SwitchView switchView = homepage.clickSwitches();
        switchView.toggleSwitch();
        switchView.verifyPage();
    }
}
