import AppiumUtil.AppiumConfiguration;
import org.testng.annotations.Test;
import PageObjects.StackViews;

public class StackViewsTests extends AppiumConfiguration {

    @Test
    public void clickStackView(){
        try {
            StackViews stackViews = homepage.clickStackViews();
            stackViews.verifyStackViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
