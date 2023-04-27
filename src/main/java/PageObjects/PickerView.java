package PageObjects;

import AppiumUtil.AppiumConfiguration;
import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class PickerView extends SharedUtilities {

    IOSDriver driver;
    SoftAssert softAssert;

    public PickerView(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Red color component value'")
    private WebElement redColorComponent;
    @iOSXCUITFindBy(accessibility = "Green color component value")
    private WebElement greenColorComponent;
    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private WebElement blueColorComponent;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'UIKitCatalog'`]")
    private WebElement backButton;

    public void colorMixer() {
        sendKeys(redColorComponent, "250");
        sendKeys(greenColorComponent, "65");
        sendKeys(blueColorComponent, "75");
    }

    public void assertColorKeys() {
        softAssert.assertEquals(redColorComponent.getAttribute("value"), 65);
        softAssert.assertEquals(greenColorComponent.getAttribute("value"), 205);
        softAssert.assertEquals(blueColorComponent.getAttribute("value"), 120);
    }

    public void navigateBack() {
        clickOnField(backButton);
    }


}
