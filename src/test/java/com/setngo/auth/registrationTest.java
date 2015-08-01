package com.setngo.auth;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class registrationTest {

	AppiumDriver<MobileElement> dr;

	@Test
	public void testApp() throws MalformedURLException {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File app = new File(classpathRoot, "/apps/app.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Sample_Emulator");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());

		dr = new AndroidDriver<MobileElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), capabilities);

		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(dr, 10);
		
	}

}
