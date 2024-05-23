package com.harsh.globalvariable;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
/**
 * 
 * @author Harsh Gujrati
 * Do not delete driver variable , this will crash the framework.
 *
 */

public class GlobalVariable {
	public static AppiumDriver<WebElement> driver ;

}
