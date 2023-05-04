package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SwitchView extends SharedUtilities {

    IOSDriver driver;
    SoftAssert softAssert;

    public SwitchView(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Switches'`]")
    private WebElement switchPageTitle;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'DEFAULT'")
    private WebElement listLabel;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'TINTED'")
    private WebElement listLabel2;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[1]")
    private WebElement switchOne;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton")
    private WebElement previousBtn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[2]")
    private WebElement switchTwo;

    public void verifyPage() {
        Assert.assertEquals(switchPageTitle.getText(), "Switches");
        Assert.assertEquals(listLabel.getText(), "DEFAULT");
        Assert.assertEquals(listLabel2.getText(), "TINTED");
        Assert.assertEquals(switchOne.getAttribute("value"), 1);
        Assert.assertEquals(switchTwo.getAttribute("value"), 1);
    }

    public void toggleSwitch() {
        clickOnField(switchOne);
        Assert.assertEquals(switchOne.getAttribute("value"), 0);
        clickOnField(switchTwo);
        Assert.assertEquals(switchTwo.getAttribute("value"), 0);
        clickOnField(previousBtn);
//        org.PageObjects.Homepage homepage = new org.PageObjects.Homepage(driver);
//        homepage.clickSwitches();
//        clickOnField(previousBtn);
    }

}
