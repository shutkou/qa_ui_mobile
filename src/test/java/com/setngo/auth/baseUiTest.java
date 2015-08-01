package com.setngo.auth;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseUiTest {

	protected AppiumDriver<WebElement> dr;
	protected WebDriverWait wait;
	protected DesiredCapabilities capabilities = new DesiredCapabilities();
	protected File classpathRoot = new File(System.getProperty("user.dir"));
	protected String appiumServer = "http://localhost:4723/wd/hub";
	
	protected AndroidDriver<WebElement> setUpAndroidDriver() throws Exception {
	
	File app = new File(classpathRoot, "/apps/app.apk");

	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Sample_Emulator");
	capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

	dr = new AndroidDriver<WebElement>(new URL(appiumServer), capabilities);

	postDriverInit();
	return (AndroidDriver<WebElement>) dr;
	}
	
	protected void postDriverInit() throws Exception {
        dr.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        wait = new WebDriverWait(dr, 20);
    }
}
