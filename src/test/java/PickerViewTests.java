import AppiumUtil.AppiumConfiguration;
import org.testng.annotations.Test;
import PageObjects.PickerView;

public class PickerViewTests extends AppiumConfiguration {

    @Test(groups = {"Smoke"})
    public void clickPickerView() {
        try {
            PickerView pickerView = homepage.colorMixer();
            pickerView.assertColorKeys();
            pickerView.navigateBack();
        } catch (Exception e) {
            if (e instanceof Throwable) {
                e.printStackTrace();
            }
        }
    }



    @Test (groups = {"Smoke"})
    public void setColor(){
        PickerView pickerView = homepage.colorMixer();
        pickerView.colorMixer();
    }

    @Test
    public void printNumberOfElementsInPickerView() {
        // Initialize the page object
        PickerView pickerView = homepage.colorMixer();

//        // Wait for the color mixer to be visible
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(pickerView.getColorMixer()));

        // Get the number of elements in the picker view
        int numberOfElements = pickerView.getNumberOfPickerViewElements();

        // Print the number of elements
        System.out.println("Number of elements in the picker view: " + numberOfElements);
    }

}
