package AppiumUtil;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SharedUtilities{

         IOSDriver driver;

        public SharedUtilities(IOSDriver driver)
        {
            this.driver = driver;
        }

    public void longPressAction(WebElement element)
        {
            Map<String,Object> params = new HashMap<>();
            params.put("element", ((RemoteWebElement)element).getId());
            params.put("duration", 5);
            driver.executeScript("mobile:touchAndHold", params);
        }

        public void scrollToWebElement(WebElement element)
        {
            Map<String,Object> params = new HashMap<>();
            params.put("direction", "down");
            params.put("element", ((RemoteWebElement)element).getId());
            driver.executeScript("mobile:scroll", params);
        }


        public void swipeAction(WebElement element ,String direction)
        {
            Map<String,Object> params = new HashMap<String,Object> ();
            params.put("direction","left");
            params.put("element", ((RemoteWebElement)element).getId());
            driver.executeScript("mobile:swipe", params);
        }

        public void clickOnField(WebElement element){
            element.click();
        }

        public void sendKeys(WebElement element, String text) {
            element.clear();
            element.sendKeys(text);
        }

        public String captureScreenShot(String testCaseName, IOSDriver driver) throws IOException {
            File source = driver.getScreenshotAs(OutputType.FILE);
            String destinationFile = System.getProperty("user.dir") + "//reports" + testCaseName+".png";
            FileUtils.copyFile(source, new File(destinationFile));
            return destinationFile;
        }

}
