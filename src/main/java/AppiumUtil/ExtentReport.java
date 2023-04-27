package AppiumUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeTest;

public class ExtentReport {
    static ExtentReports extentReports;

    @BeforeTest
    public static ExtentReports extentReport() {
        String reportPath = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Automation Report");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);

        return extentReports;
    }
}
