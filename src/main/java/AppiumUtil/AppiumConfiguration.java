package AppiumUtil;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.PageObjects.Homepage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AppiumConfiguration {
    public IOSDriver driver;
    public AppiumDriverLocalService builder;
    public Homepage homepage;


    @BeforeClass
    public void initializeAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");
        properties.load(fileInputStream);

        String ipAddress = properties.getProperty("ipAddress");
        String port = properties.getProperty("port");
        String device = properties.getProperty("device");
        String osVersion = properties.getProperty("osVersion");

        try {
            AppiumDriverLocalService builder = new AppiumServiceBuilder()
                    .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                    .usingDriverExecutable(new File("/usr/local/bin/node"))
                    .withIPAddress(ipAddress).usingPort(Integer.parseInt(port)).build();

            builder.start();

            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName(device);
            options.setApp("/Users/aj/Documents/AutomationPortfolio/resources/UIKitCatalog.app");
            options.setPlatformVersion(osVersion);
            options.setWdaLaunchTimeout(Duration.ofSeconds(20));

            driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            homepage = new Homepage(driver);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown(){
        try {
            driver.quit();
            if (builder != null) {
                builder.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error occurred during teardown: " + e.getMessage());
        }
    }

}