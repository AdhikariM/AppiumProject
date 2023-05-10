import AppiumUtil.AppiumConfiguration;
import PageObjects.AlertViews;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertViewsTests extends AppiumConfiguration {

    @Test
    public void clickAlertView() {
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
}
