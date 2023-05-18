package AppiumUtil;

import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

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

    public String captureScreenshot(String testCaseName) throws IOException {
        File sourceFile = driver.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testCaseName + ".png";
        File destinationFile = new File(destinationPath);
        Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return destinationPath;
    }

}
