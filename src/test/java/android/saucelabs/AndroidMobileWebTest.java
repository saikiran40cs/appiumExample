package android.saucelabs;

import org.junit.Before;
import org.junit.Test;

public class AndroidMobileWebTest extends SauceTestClass {

    @Before
    public void setUp() throws Exception {
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("browserName", "Browser");
        super.setUpAndroidDriver();
    }

    @Test
    public void basicAndroidWebTest() throws Exception {
        runWebTest();
    }
}
