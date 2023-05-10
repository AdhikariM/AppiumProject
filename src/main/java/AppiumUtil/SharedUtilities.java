package AppiumUtil;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedUtilities {

    private IOSDriver driver;

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

    public String getScreenshotPath(String testCaseName) throws IOException {
        String timeStamp = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
        TakesScreenshot screenshot = this.driver;
        if (screenshot != null) {
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String destinationPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testCaseName + "_" + timeStamp + ".png";
            File destination = new File(destinationPath);
            FileUtils.copyFile(source, destination);
            return destinationPath;
        }
        return null;
    }


}
