package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StackViews extends SharedUtilities {

    IOSDriver driver;
    public StackViews(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Stack Views'")
    private WebElement stackViewsPageTitle;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Showing/hiding views'")
    private WebElement sectionHeader;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Detail'")
    private WebElement detailLabel;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'stepper increment'`][1]")
    private WebElement plusBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Footer Label'")
    private WebElement footerLabel;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Add/remove views'")
    private WebElement addRemoveLabel;
    @iOSXCUITFindBy (iOSClassChain = "**/XCUIElementTypeButton[`label == 'stepper increment'`][2]")
    private WebElement plusBtn2;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'stepper decrement'")
    private WebElement minusBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Further Detail'")
    private WebElement furtherLabel;
//    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
//    private WebElement textBox1;
//    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
//    private WebElement textBox2;
    // resolve these identifiers

    public void verifyStackViews(){
        Assert.assertEquals(stackViewsPageTitle.getText(), "Stack Views");
        Assert.assertEquals(sectionHeader.getText(), "Showing/hiding views");
        Assert.assertEquals(detailLabel.getText(), "Detail");
        Assert.assertEquals(footerLabel.getText(), "Footer Label");
        Assert.assertEquals(addRemoveLabel.getText(), "Add/remove views");
    }


}
