package android.saucelabs;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;

public class AndroidNativeTest extends SauceTestClass {

    @Before
    public void setUp() throws Exception {
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("app", getApp("ContactManager.apk"));
        super.setUpAndroidDriver();
    }

    @Test
    public void basicAndroidNativeTest() throws Exception {
        driver.findElement(MobileBy.AccessibilityId("Add Contact")).click();
        List<WebElement> fields = driver.findElements(By.className("android.widget.EditText"));
        fields.get(0).sendKeys("My Name");
        fields.get(2).sendKeys("someone@somewhere.com");
        assertEquals(fields.get(0).getText(), "My Name");
        assertEquals(fields.get(2).getText(), "someone@somewhere.com");
        driver.navigate().back();
    }
}
