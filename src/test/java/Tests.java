import AppiumUtil.AppiumConfiguration;
import PageObjects.Homepage;
import org.testng.annotations.Test;

public class Tests extends AppiumConfiguration {

    @Test (groups = "Smoke")
    public void verifyHome(){
        try {
            Homepage homepage = new Homepage(driver);
            homepage.verifyHomePage();
        } catch (Exception e){
         e.printStackTrace();
        }
    }
}


