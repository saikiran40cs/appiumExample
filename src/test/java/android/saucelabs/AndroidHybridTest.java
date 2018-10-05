package android.saucelabs;

import org.junit.Before;
import org.junit.Test;

public class AndroidHybridTest extends SauceTestClass {

    @Before
    public void setUp() throws Exception {
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", getApp("HelloGappium-android.apk"));
        super.setUpAndroidDriver();
    }

    @Test
    public void basicAndroidHybridTest() throws Exception {
        runHybridTest();
    }
}
