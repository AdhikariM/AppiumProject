package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SliderView extends SharedUtilities {

    IOSDriver driver;

    public SliderView(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "//*[@text='UIKitCatalog' and @top='true']")
    private WebElement pageTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name='UIKitCatalog']/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeSlider")
    private WebElement sliderOne;

    public void setSlider() {
        sliderOne.sendKeys("0.5");
    }
}
