package com.serosoft.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.appium.commonactionmethods.CommonMobileActions;
import com.harsh.globalvariable.GlobalVariable;
import com.serosoft.pages.*;

public class LoginSteps extends GlobalVariable {

	@When("I enter username as {string}")
	public void iEnterUsernameAs(String username) throws Exception {

		LoginPage.enterUsername(username);
	}

	@And("I enter password as {string}")
	public void iEnterPasswordAs(String password) throws Exception {

		new LoginPage().enterPassword(password);

	}

	@And("I login")
	public void iLogin() throws Exception {
		new LoginPage().clickOnLoginButton();
	}

	@Then("I am on homepage")
	public void validateHomePage() throws Exception {
		new LoginPage().validateHomeScreen();

	}

	@Then("I click on {string} from the menu")
	public void clickOptionFromMenu(String option) throws Exception {
       new LoginPage().clickMenu();
       new CommonLoactorPage().clickOnAndroidTextLocator("LOGOUT");
	}

}
