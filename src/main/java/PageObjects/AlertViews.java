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

    @iOSXCUITFindBy(id = "Alert Views")
    private WebElement pageTitle;
    @iOSXCUITFindBy(id = " ALERT STYLE")
    private WebElement menuTitle;
    @iOSXCUITFindBy(id = "Simple")
    private WebElement simpleBtn;
    @iOSXCUITFindBy(id = " Okay / Cancel")
    private WebElement oCBtn;
    @iOSXCUITFindBy(id = "Other")
    private WebElement otherBtn;
    @iOSXCUITFindBy(xpath = "//*[@value='Text Entry']")
    private WebElement textBtn;
    @iOSXCUITFindBy(id = "Secure Text Entry")
    private WebElement secureBtn;
    @iOSXCUITFindBy (id = " Confirm / Cancel")
    private  WebElement confirmCancelBtn;
    @iOSXCUITFindBy(id = "Destructive")
    private WebElement destructiveBtn;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
    private WebElement textbox;
    @iOSXCUITFindBy(id = "OK")
    private WebElement okBtn;

    public void verifyPage(){
        Assert.assertEquals(pageTitle.getText(), "Alert Views");

    }

    public void fillTextBox(String text){
        textBtn.click();
        textbox.sendKeys(text);
        okBtn.click();

    }

    public void getConfirmMessage(){

    }



}