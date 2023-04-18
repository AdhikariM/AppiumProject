package AppiumUtil;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.PageObjects.Homepage;
import org.openqa.selenium.remote.http.HttpClient;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumConfiguration {
    public IOSDriver driver;
    public AppiumDriverLocalService builder;
    public Homepage homepage;


    @BeforeClass
    public void initializeAppium() {
        try {
            AppiumDriverLocalService builder = new AppiumServiceBuilder()
                    .withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                    .usingDriverExecutable(new File("/usr/local/bin/node"))
                    .withIPAddress("127.0.0.1").usingPort(4723).build();

            builder.start();

            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName("iPhone 14 Pro");
            options.setApp("/Users/aj/Documents/AutomationPortfolio/resources/UIKitCatalog.app");
            options.setPlatformVersion("16.4");
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