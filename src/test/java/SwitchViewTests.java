import AppiumUtil.AppiumConfiguration;
import org.testng.annotations.Test;
import PageObjects.SwitchView;

public class SwitchViewTests extends AppiumConfiguration {

    private SwitchView switchView;

    @Test
    //bug in app [java.lang.AssertionError: expected [0] but found [0]]
    public void clickSwitchesView() {
        switchView = homepage.clickSwitches();
        switchView.verifyPage();
    }

    @Test
    public void clickSwitch(){
        switchView.toggleSwitch();
    }
}
