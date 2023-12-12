package slappinstallation;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import slbasereport.BaseTest;
import java.net.MalformedURLException;
import java.net.URL;

public class AppInstallationTest extends BaseTest {
    @Test
    public void InstallationAPPTest1() throws MalformedURLException {
        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"9.0");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        dc.setCapability(MobileCapabilityType.APP,ApkUrl);
        URL url=new URL("http://127.0.0.1:4725/wd/hub");
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(url,dc);
        driver.quit();
    }
}
