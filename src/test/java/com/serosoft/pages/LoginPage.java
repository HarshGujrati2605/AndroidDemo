package com.serosoft.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appium.commonactionmethods.CommonMobileActions;
import com.harsh.globalvariable.GlobalVariable;

import io.appium.java_client.AppiumDriver;

//import okio.Timeout;
//import io.appium.java_client.MobileElement;

public class LoginPage extends GlobalVariable {

	static By Username = By.xpath("//android.widget.EditText[@text = 'Username']");
	By Password = By.xpath("//android.widget.EditText[@text = 'Password']");
	By SigninButton = By.xpath("//android.widget.TextView[@text = 'LOGIN']/..");
	By menu = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]");

	public static void enterUsername(String username) throws Exception {

		CommonMobileActions.clickOnElementAndType(Username, username, "Username field");
		Thread.sleep(8000);

	}

	public void enterPassword(String password) throws Exception {

		CommonMobileActions.clickOnElementAndType(Password, password, "Password field");

	}

	public void clickOnLoginButton() throws Exception {

		WebElement signin = CommonMobileActions.getElement(SigninButton);
		CommonMobileActions.iClick(signin, "Login button");
	}

	public void validateHomeScreen() throws Exception {
		CommonMobileActions.isDisplayed(menu, "App menu");
	}
	
	public void clickMenu() throws Exception {
		CommonMobileActions.iClickElementByLocator(menu, "Menu");
	}
}
