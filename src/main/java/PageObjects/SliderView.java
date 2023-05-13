package PageObjects;

import AppiumUtil.SharedUtilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SliderView extends SharedUtilities {

    IOSDriver driver;

    public SliderView(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "//*[@text='UIKitCatalog' and @top='true']")
    private WebElement pageTitle;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[1]")
    private WebElement sliderOne;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[2]")
    private WebElement sliderTwo;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[3]")
    private WebElement sliderThree;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSlider[4]")
    private WebElement sliderFour;

    public void setSlider() {

        sliderOne.sendKeys("0.5");
        sliderTwo.sendKeys("0.75");
        sliderThree.sendKeys("0.0");
        sliderFour.sendKeys("0.88");

    }

    public void verifyValues(){
        Assert.assertEquals(sliderOne.getAttribute("value"), "50%");
        Assert.assertEquals(sliderTwo.getAttribute("value"), "76%");
        Assert.assertEquals(sliderThree.getAttribute("value"), "0%");
        Assert.assertEquals(sliderFour.getAttribute("value"), "90%");
    }
}
