package AppiumUtil;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SharedUtilities {

    private static final String VIDEO_FORMAT = ".mp4";
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

    public String getScreenshotPath(String testCaseName, IOSDriver driver) throws IOException {
        String timeStamp = new SimpleDateFormat("YYYYMMddHHmmss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) this.driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "/test-output/screenshots/" + testCaseName + "_" + timeStamp + ".png";
        File destination = new File(destinationPath);
        FileUtils.copyFile(source, destination);
        return destinationPath;
    }

    public void recordVideoOnFailure(String testName) {
        try {
            // Set the directory for the videos
            String videosDir = System.getProperty("user.dir") + "/test-output/videos/";
            new File(videosDir).mkdirs();

            // Set the format and file name for the video
            String videoFileName = testName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + VIDEO_FORMAT;

            // Start video recording
            DesiredCapabilities recordingCaps = new DesiredCapabilities();
            recordingCaps.setCapability("captureType", "video");
            recordingCaps.setCapability("forceRestart", true);
            recordingCaps.setCapability("noReset", true);
            recordingCaps.setCapability("videoType", "libx264");
            recordingCaps.setCapability("videoName", videoFileName);
            driver.executeScript("mobile: startRecordingScreen", recordingCaps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopVideoRecordingOnFailure(String testName) {
        try {
            // Stop video recording
            String videoRecording = (String) driver.executeScript("mobile: stopRecordingScreen");

            // Set the directory for the videos
            String videosDir = System.getProperty("user.dir") + "/test-output/videos/";
            new File(videosDir).mkdirs();

            // Set the format and file name for the video
            String videoFileName = testName + "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + VIDEO_FORMAT;

            // Save the video recording to a file
            File videoFile = new File(videosDir + videoFileName);
            videoFile.createNewFile();
            FileUtils.copyFile(new File(videoRecording), videoFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
