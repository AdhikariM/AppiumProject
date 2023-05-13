import AppiumUtil.AppiumConfiguration;
import PageObjects.SliderView;
import org.testng.annotations.Test;

public class SliderTests extends AppiumConfiguration {
    @Test
    public void slider() {
        SliderView sliderView = homepage.clickSliderView();
        sliderView.setSlider();
    }

    @Test
    public void verify(){
        SliderView sliderView = homepage.clickSliderView();
        sliderView.verifyValues();
    }
}
