import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
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


    @BeforeClass
    public void initializeAppium() throws MalformedURLException {
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

        driver = new IOSDriver(new URL("http://127.0.0.1:4723"),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
//TO DO - fix this failure due to imcompatibility
    @AfterClass
    public void tearDown(){
        System.out.println(1);
        driver.quit();
        System.out.println(2);
        builder.stop();
        System.out.println(3);
    }


}
