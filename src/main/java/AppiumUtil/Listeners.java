package AppiumUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.ios.IOSDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    ExtentReports extentReports  = ExtentReport.extentReport();
    ExtentTest test;
    IOSDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
    test = extentReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
    extentReports.flush();
    }
}
