package AppiumUtil;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.PageObjects.Homepage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class AppiumConfiguration {
    public static IOSDriver driver;
    public static AppiumDriverLocalService builder;
    public static Homepage homepage;

    @BeforeSuite(alwaysRun = true)
    public void startAppium() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");
        properties.load(fileInputStream);

        String ipAddress = properties.getProperty("ipAddress");
        String port = properties.getProperty("port");

        builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .withIPAddress(ipAddress)
                .usingPort(Integer.parseInt(port)).build();
        builder.start();
    }

    @BeforeClass(alwaysRun = true)
    public void openApp() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//data.properties");
        properties.load(fileInputStream);

        String device = properties.getProperty("device");
        String osVersion = properties.getProperty("osVersion");

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(device);
        options.setApp("/Users/aj/Documents/AutomationPortfolio/resources/UIKitCatalog.app");
        options.setPlatformVersion(osVersion);
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homepage = new Homepage(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppium() {
        if (builder != null) {
            builder.stop();
        }
    }
}
