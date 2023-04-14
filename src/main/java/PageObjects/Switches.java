package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Switches extends SharedUtilities {

    IOSDriver driver;
    public Switches(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Switches'")
    private WebElement switchPageTitle;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'DEFAULT'")
    private WebElement listLabel;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'TINTED'")
    private WebElement listLabel2;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[1]")
    private WebElement switchOne;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'UIKitCatalog' AND name == 'UIKitCatalog' AND type == 'XCUIElementTypeButton'")
    private WebElement previousBtn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[2]")
    private WebElement switchTwo;

    public void verifyPage(){
        Assert.assertEquals(switchPageTitle.getText(), "Switches");
        Assert.assertEquals(listLabel.getText(), "DEFAULT");
        Assert.assertEquals(listLabel2.getText(), "TINTED");

    }

    public void toggleSwitch(){
        switchOne.click();
        switchTwo.click();
        previousBtn.click();
        org.PageObjects.Homepage homepage = new org.PageObjects.Homepage(driver);
        homepage.clickSwitches();
    }

}
