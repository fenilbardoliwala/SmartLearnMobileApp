package slappinstallation;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import slbasereport.BaseTest;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Rotatable;
//import org.openqa.selenium.HasFederatedCredentialManagement;

public class AppInstallationTest {
    @Test
    public void InstallationAPPTest1() throws MalformedURLException {
        try {
            AppiumDriver<MobileElement> appiumDriver;
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
            dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
            dc.setCapability(MobileCapabilityType.APP, "D:\\FenilIT\\AndroidTesting\\smartLearn(test).apk");
           // URL appiumServer = new URL("http://localhost:4725/wd/hub");
            AppiumDriver<MobileElement>driver=new AndroidDriver<>(new URL("http://localhost:4725/wd/hub"),dc);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
