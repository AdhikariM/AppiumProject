import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class SharedUtilities extends AppiumConfiguration{
    @Test
    public void basicTest(){
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    }
}
