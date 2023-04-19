import AppiumUtil.AppiumConfiguration;
import org.testng.annotations.Test;
import PageObjects.PickerView;

public class PickerViewTests extends AppiumConfiguration {

    @Test
    public void clickPickerView() {
        try {
            PickerView pickerView = homepage.colorMixer();
            pickerView.assertColorKeys();
            pickerView.colorMixer();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
