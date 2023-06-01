package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TextFieldsPage extends SharedUtilities {

    private IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Standard")
    private WebElement standardTextField;

    @iOSXCUITFindBy(accessibility = "Secure")
    private WebElement secureTextField;

    @iOSXCUITFindBy(accessibility = "Return")
    private WebElement returnButton;

    public TextFieldsPage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterTextInStandardField(String text) {
        sendKeys(standardTextField, text);
    }

    public void enterTextInSecureField(String text) {
        sendKeys(secureTextField, text);
    }

    public void tapReturnButton() {
        clickOnField(returnButton);
    }

    public String getTextFromStandardField() {
        return standardTextField.getAttribute("value");
    }

    public String getTextFromSecureField() {
        return secureTextField.getAttribute("value");
    }
}
