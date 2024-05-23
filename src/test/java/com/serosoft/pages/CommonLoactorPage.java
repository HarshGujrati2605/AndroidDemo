package com.serosoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.appium.commonactionmethods.CommonMobileActions;

public class CommonLoactorPage {

	
	public void iValidateTitle(String option) throws Exception {
		Thread.sleep(4000);
		WebElement title = CommonMobileActions.getElement(By.xpath("//android.widget.TextView[contains(@text , '"+option+"')]"));
		String actualtext = CommonMobileActions.iGetText(title, "Title actual text");
		CommonMobileActions.iLogMessage("*****" +actualtext + "*****");
		if(actualtext.toLowerCase().contains(option.toLowerCase())) {
			CommonMobileActions.iLogMessage("Title is correct");
		}
		else {
			throw new Exception("Title is not correct");
		}
	}
	
	public void clickOnAndroidTextLocator(String text) throws Exception {
		WebElement title = CommonMobileActions.getElement(By.xpath("//android.widget.TextView[@text  ='"+text+"']/.."));
		CommonMobileActions.iClick(title, "clicked on button "+text+"");
	}
}
