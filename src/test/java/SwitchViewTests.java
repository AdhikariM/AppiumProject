import AppiumUtil.AppiumConfiguration;
import org.testng.annotations.Test;
import PageObjects.SwitchView;

public class SwitchViewTests extends AppiumConfiguration {

    @Test
    public void clickSwitchesView(){
        SwitchView switchView = homepage.clickSwitches();
        switchView.verifyPage();
        switchView.toggleSwitch();

    }
}
