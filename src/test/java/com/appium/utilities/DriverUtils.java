package com.appium.utilities;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import com.appium.commonactionmethods.CommonMobileActions;
import com.harsh.Enums.DEVICETYPE;
import com.harsh.globalvariable.Constants;
import com.harsh.globalvariable.GlobalVariable;
import com.serosoft.base.BaseClass;

/**
 * 
 * @author Harsh Gujrati
 * Do not Modify any functions . If required to ad more choices or integration , contact harsh.gujrati@serosoft.in
 *
 */
public  class DriverUtils extends GlobalVariable{
	public static String choice ;
	public static String username= Constants.getUsername();
	public static String  Accesskey = Constants.getPassword();
	public static final String urlbrowserstack = "https://" + username + ":"+ Accesskey + "@hub-cloud.browserstack.com/wd/hub";
	
	@SuppressWarnings("rawtypes")
	public static AppiumDriver getDriver() throws IOException {
			
		choice = BaseClass.getCloudDeviceChoice();
		switch(choice.toLowerCase()) {
		  case "browserstack":	
				try {
					CommonMobileActions.iLogMessage("Cloud device selected..");
					DesiredCapabilities caps = new DesiredCapabilities();				
					caps.setCapability("deviceName", "Google Pixel 3");
					caps.setCapability("os_version", "9.0");
					caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
					caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BaseClass.getappPackage());
//					caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, BaseClass.getappActivity());
					caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
					caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");	
					caps.setCapability(MobileCapabilityType.APP, "bs://b185f4aa15f66d3e895d2f677848590c391bc465");		
					URL url = new URL(urlbrowserstack);
					driver = new AppiumDriver(url, caps);
					CommonMobileActions obj = new CommonMobileActions(driver);
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Driver initialization error");
				}		
		    break;
		  case "localdevice":		
				try {
					CommonMobileActions.iLogMessage("Local device selected..");
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
					caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BaseClass.getappPackage());
					caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, BaseClass.getappActivity());
					caps.setCapability(MobileCapabilityType.UDID, BaseClass.getUDID());
					caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
					caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
					caps.setCapability(MobileCapabilityType.APP,
							BaseClass.getAppLocation());				
					URL url = new URL(BaseClass.getURL());
					driver = new AppiumDriver(url, caps);
					CommonMobileActions obj = new CommonMobileActions(driver);
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Driver initialization error");

				}			
		    break;
		  default:			
				try {
					CommonMobileActions.iLogMessage("Local device selected.");
					DesiredCapabilities caps = new DesiredCapabilities();
					caps.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
					caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BaseClass.getappPackage());
					caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, BaseClass.getappActivity());
					caps.setCapability(MobileCapabilityType.UDID, BaseClass.getUDID());
					caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
					caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
					caps.setCapability(MobileCapabilityType.APP,
							BaseClass.getAppLocation());				
					URL url = new URL(BaseClass.getURL());
					driver = new AppiumDriver(url, caps);
					CommonMobileActions obj = new CommonMobileActions(driver);
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Driver initialization error");

				}		
				
		}
				
	return driver;		
	}
	
}
