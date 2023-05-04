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
}
