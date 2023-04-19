import AppiumUtil.AppiumConfiguration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObjects.AlertViews;

public class AlertViewsTests extends AppiumConfiguration {

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
}
