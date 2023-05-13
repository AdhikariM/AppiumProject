package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class Homepage extends SharedUtilities {

    IOSDriver driver;
    SoftAssert softAssert;

    public Homepage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.softAssert = new SoftAssert();
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`value == 'UIKitCatalog'`]")
    private WebElement pageTitle;
    @iOSXCUITFindBy(accessibility = "Activity Indicators")
    private WebElement activityI;
    @iOSXCUITFindBy(accessibility = "ActivityIndicatorViewController")
    private WebElement activityIVC;
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViews;
    @iOSXCUITFindBy(accessibility = "AlertControllerViewController")
    private WebElement alertCVC;
    @iOSXCUITFindBy(accessibility = "Buttons")
    private WebElement buttons;
    @iOSXCUITFindBy(accessibility = "ButtonViewController")
    private WebElement buttonVC;
    @iOSXCUITFindBy(accessibility = "Date Picker")
    private WebElement datePicker;
    @iOSXCUITFindBy(accessibility = "DatePickerController")
    private WebElement datePC;
    @iOSXCUITFindBy(accessibility = "Image View")
    private WebElement imageView;
    @iOSXCUITFindBy(accessibility = "ImageViewController")
    private WebElement imageVC;
    @iOSXCUITFindBy(accessibility = "Page Control")
    private WebElement pageControl;
    @iOSXCUITFindBy(accessibility = "PageControlViewController")
    private WebElement pageCVC;
    @iOSXCUITFindBy(accessibility = "Picker View")
    private WebElement pickerView;
    @iOSXCUITFindBy(accessibility = "PickerViewController")
    private WebElement pickerVC;
    @iOSXCUITFindBy(accessibility = "Progress Views")
    private WebElement progressViews;
    @iOSXCUITFindBy(accessibility = "ProgressViewController")
    private WebElement progressVC;
    @iOSXCUITFindBy(accessibility = "Search")
    private WebElement search;
    @iOSXCUITFindBy(accessibility = "SearchViewControllers")
    private WebElement searchVC;
    @iOSXCUITFindBy(accessibility = "Segmented Controls")
    private WebElement segmentedControls;
    @iOSXCUITFindBy(accessibility = "SegmentedControlViewController")
    private WebElement segmentedCVC;
    @iOSXCUITFindBy(accessibility = "Sliders")
    private WebElement sliders;
    @iOSXCUITFindBy(accessibility = "SliderViewController")
    private WebElement sliderVC;
    @iOSXCUITFindBy(accessibility = "Stack Views")
    private WebElement stackViews;
    @iOSXCUITFindBy(accessibility = "StackViewController")
    private WebElement stackVC;
    @iOSXCUITFindBy(accessibility = "Steppers")
    private WebElement steppers;
    @iOSXCUITFindBy(accessibility = "StepperViewController")
    private WebElement stepperVC;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[14]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private WebElement switches;
    @iOSXCUITFindBy(accessibility = "SwitchViewController")
    private WebElement switchVC;
    @iOSXCUITFindBy(accessibility = "Text Fields")
    private WebElement textFields;
    @iOSXCUITFindBy(accessibility = "TextFieldViewController")
    private WebElement textFVC;
    @iOSXCUITFindBy(accessibility = "Text View")
    private WebElement textView;
    @iOSXCUITFindBy(accessibility = "TextViewController")
    private WebElement textVC;
    @iOSXCUITFindBy(accessibility = "Toolbars")
    private WebElement toolbars;
    @iOSXCUITFindBy(accessibility = "ToolbarViewControllers")
    private WebElement toolbarVC;
    @iOSXCUITFindBy(accessibility = "Web View")
    private WebElement webView;
    @iOSXCUITFindBy(accessibility = "WebViewController")
    private WebElement webVC;

    public AlertViews clickAlertViews() {
        alertViews.click();
        return new AlertViews(driver);
    }

    public SliderView clickSliderView() {
        sliders.click();
        return new SliderView(driver);
    }

    public StackViews clickStackViews() {
        stackViews.click();
        return new StackViews(driver);
    }

    public SwitchView clickSwitches() {
        switches.click();
        return new SwitchView(driver);
    }

    public PickerView colorMixer() {
        clickOnField(pickerView);
        return new PickerView(driver);
    }

    public void verifyHomePage() {

        softAssert.assertEquals(pageTitle.getText(), "UIKitCatalog");
        softAssert.assertEquals(activityI.getText(), "Activity Indicators");
        softAssert.assertEquals(activityIVC.getText(), "ActivityIndicatorViewController");
        softAssert.assertEquals(alertViews.getText(), "Alert Views");
        softAssert.assertEquals(alertCVC.getText(), "AlertControllerViewController");
        softAssert.assertEquals(buttons.getText(), "Buttons");
        softAssert.assertEquals(buttonVC.getText(), "ButtonViewController");
        softAssert.assertEquals(datePicker.getText(), "Date Picker");
        softAssert.assertEquals(datePC.getText(), "DatePickerController");
        softAssert.assertEquals(imageView.getText(), "Image View");
        softAssert.assertEquals(imageVC.getText(), "ImageViewController");
        softAssert.assertEquals(pageControl.getText(), "Page Control");
        softAssert.assertEquals(pageCVC.getText(), "PageControlViewController");
        softAssert.assertEquals(pickerView.getText(), "Picker View");
        softAssert.assertEquals(pickerVC.getText(), "PickerViewController");
        softAssert.assertEquals(progressViews.getText(), "Progress Views");
        softAssert.assertAll();


    }


}