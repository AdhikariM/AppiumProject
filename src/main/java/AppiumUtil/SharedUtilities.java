package AppiumUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedUtilities {

    IOSDriver driver;

    public SharedUtilities(IOSDriver driver) {
        this.driver = driver;
    }

    public void clickOnField(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public <MobileElement> String getScreenshotPath(String testCaseName, IOSDriver driver) throws IOException {
        String timeStamp = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testCaseName + "_" + timeStamp + ".png";
        File destination = new File(destinationPath);
        FileUtils.copyFile(source, destination);
        return destinationPath;
    }


}
