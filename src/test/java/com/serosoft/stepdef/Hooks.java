package com.serosoft.stepdef;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.mail.MessagingException;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.commonactionmethods.CommonMobileActions;
import com.harsh.globalvariable.GlobalVariable;
import com.serosoft.base.BaseClass;
import com.serosoft.base.SendEmail;
import com.serosoft.implementation.AppAcess;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;

public class Hooks extends GlobalVariable {

	@Before
	public void setup() throws IOException {
		AppAcess.openApplication();

	}

	@After
	public static void teardown(io.cucumber.java.Scenario scenario)
			throws UnsupportedEncodingException, EmailException, MessagingException {
		if (scenario.isFailed()) {
			BaseClass.captureScreenshot(scenario.getName());
			CommonMobileActions.iLogMessage("Screenshot taken");
		} else {
			CommonMobileActions.iLogMessage(scenario.getName() + " is passed");
		}

	}

	@AfterAll
	public static void sendEmails() {
		try {
//     		SendEmail.send();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
