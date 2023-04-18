package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertViews extends SharedUtilities {

    IOSDriver driver;
    public AlertViews(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Alert Views'")
    private WebElement pageTitle;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'ALERT STYLE'")
    private WebElement listTitle;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Simple'")
    private WebElement simpleBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Okay / Cancel'")
    private WebElement okayCancelBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Other'")
    private WebElement otherBtn;
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label =='Text Entry'`]")
    private WebElement textEntryBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Secure Text Entry'")
    private WebElement secureBtn;
    @iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
    private WebElement confirmCancelBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Destructive'")
    private WebElement destructiveBtn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textBox;
    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement okBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
    private WebElement confirmText;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement cancelBtn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'UIKitCatalog'`]")
    private WebElement previousBtn;
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'ACTION SHEET STYLE'")
    private WebElement actionSheetLabel;

    public void verifyPage(){
        Assert.assertEquals(previousBtn.getText(),"UIKitCatalog" );
        Assert.assertEquals(pageTitle.getText(), "Alert Views");
        Assert.assertEquals(listTitle.getText(), "ALERT STYLE");
        Assert.assertEquals(simpleBtn.getText(), "Simple");
        Assert.assertEquals(okayCancelBtn.getText(), "Okay / Cancel");
        Assert.assertEquals(otherBtn.getText(), "Other");
        Assert.assertEquals(textEntryBtn.getText(), "Text Entry");
        Assert.assertEquals(secureBtn.getText(), "Secure Text Entry");
        Assert.assertEquals(actionSheetLabel.getText(), "ACTION SHEET STYLE");
        Assert.assertEquals(confirmCancelBtn.getText(), "Confirm / Cancel");
        Assert.assertEquals(destructiveBtn.getText(), "Destructive");
    }

    public void fillTextBox(String text){
        clickOnField(textEntryBtn);
        textBox.sendKeys(text);
        clickOnField(okBtn);
    }

    public String getConfirmMessage(){
        clickOnField(confirmCancelBtn);
        return confirmText.getText();
    }
    public void navigateToHome(){
        clickOnField(cancelBtn);
        clickOnField(previousBtn);
    }


}