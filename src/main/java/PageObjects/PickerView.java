package PageObjects;

import AppiumUtil.AppiumConfiguration;
import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PickerView extends SharedUtilities {

    IOSDriver driver;
    public PickerView(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "Red color component value")
    private WebElement redColorComponent;
    @iOSXCUITFindBy(accessibility = "Green color component value")
    private WebElement greenColorComponent;
    @iOSXCUITFindBy(accessibility = "Blue color component value")
    private WebElement blueColorComponent;

    public void colorMixer(){
        redColorComponent.sendKeys("250");
        greenColorComponent.sendKeys("65");
        blueColorComponent.sendKeys("75");
    }


}
