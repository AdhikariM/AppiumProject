package AppiumUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class SharedUtilities{

         IOSDriver driver;

        public SharedUtilities(IOSDriver driver)
        {
            this.driver = driver;
        }

        public void clickOnField(WebElement element){
            element.click();
        }

        public void sendKeys(WebElement element, String text) {
            element.clear();
            element.sendKeys(text);
        }

        public String getScreenshotPath(String testCaseName, IOSDriver driver) throws IOException {
            File source = driver.getScreenshotAs(OutputType.FILE);
            String destinationFile = System.getProperty("user.dir") + "//reports" + testCaseName+".png";
            FileUtils.copyFile(source, new File(destinationFile));
            return destinationFile;
        }

}
