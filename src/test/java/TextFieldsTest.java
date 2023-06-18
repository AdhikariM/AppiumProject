import AppiumUtil.AppiumConfiguration;
import PageObjects.TextFieldsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TextFieldsTest extends AppiumConfiguration {

    @Test
    public void testEnterTextInStandardField() {
        TextFieldsPage textFieldsPage = new TextFieldsPage(driver);
        String inputText = "Hello, Appium!";
        textFieldsPage.enterTextInStandardField(inputText);
        String enteredText = textFieldsPage.getTextFromStandardField();
        Assert.assertEquals(enteredText, inputText);
    }

    @Test
    public void testEnterTextInSecureField() {
        TextFieldsPage textFieldsPage = new TextFieldsPage(driver);
        String inputText = "Secret123";
        textFieldsPage.enterTextInSecureField(inputText);
        String enteredText = textFieldsPage.getTextFromSecureField();
        Assert.assertEquals(enteredText, inputText);
    }

    @Test
    public void testTapReturnButton() {
        TextFieldsPage textFieldsPage = new TextFieldsPage(driver);
        textFieldsPage.enterTextInStandardField("Test Input");
        textFieldsPage.tapReturnButton();
        String enteredText = textFieldsPage.getTextFromStandardField();
        Assert.assertTrue(enteredText.isEmpty());
    }
}
