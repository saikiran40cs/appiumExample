package android.saikiranpro.test;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public abstract class Helper {
    protected AppiumDriver<WebElement> driver;
    protected DesiredCapabilities capabilities = new DesiredCapabilities();
    protected String appiumServer = "http://0.0.0.0:4723/wd/hub";
    private static final Date date = new Date();


    protected String getApp(String appFile) {
        File projectRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(projectRoot, "apps");
        File app = new File(appDir, appFile);
        return app.toString();
    }

    protected String getVersion(String defaultVersion) {
        String userVer = System.getenv("VER");
        if (userVer != null) {
            return userVer;
        }
        return defaultVersion;
    }

    protected IOSDriver<WebElement> setUpIosDriver() throws Exception {
        preDriverInit();
        capabilities.setCapability("platformName", "iOS");
        driver = new IOSDriver<WebElement>(new URL(appiumServer), capabilities);
        postDriverInit();
        return (IOSDriver<WebElement>) driver;
    }

    protected AndroidDriver<WebElement> setUpAndroidDriver(String appiumVersion,String udid,String appPackage,String appActivity) throws Exception {
        preDriverInit();
        capabilities.setCapability("appium-version", appiumVersion);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "android");
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appActivity);

        // Set job name
        capabilities.setCapability("name", "Android Sample" + date);
        driver = new AndroidDriver<WebElement>(new URL(appiumServer), capabilities);
        postDriverInit();
        return (AndroidDriver<WebElement>) driver;
    }

    protected void preDriverInit() {
    }

    protected void postDriverInit() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    protected void switchToWebview() throws Exception {
        Set<String> contexts = driver.getContextHandles();
        // => ['NATIVE_APP', 'WEBVIEW_1', ...]
        // make sure we have something other than the native context
        assertThat(contexts.size(), greaterThan(1));
        for (String context : contexts) {
            if (!context.equals("NATIVE_APP")) {
                driver.context(context);
                break;
            }
        }
    }

   

    @After
    public void tearDown() throws Exception {
    	if (driver != null) driver.quit();
    }
}
