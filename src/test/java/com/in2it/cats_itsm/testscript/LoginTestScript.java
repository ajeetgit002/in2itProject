package com.in2it.cats_itsm.testscript;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.in2it.cats_itsm.basetest.BaseTest;
import com.in2it.cats_itsm.constant.AppConstant;
import com.in2it.cats_itsm.pages.LoginPage;
import com.in2it.cats_itsm.pagesOR.LoginPageOR;
import com.in2it.cats_itsm.utilities.DataProviders;
import com.in2it.cats_itsm.utilities.RetryAnalyzer;

public class LoginTestScript extends BaseTest {

	@Test(priority = 2, groups = {
			"@regression" }, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void verifyLogin(String username, String password, String result) {

		LoginPage login = new LoginPage(ut, driver);

		if (result.equalsIgnoreCase("valid")) {
			System.out.println(username + "," + password + "," + result);
			login.enterCredential(username, password);

			extentTest.log(Status.INFO, "Entered value is : " + result);

			login.clickLoginButton();

			ut.verifyInnerText(home.getWelcomeINT(), AppConstant.homepage_landing_massage);
			ut.threadWait(5000);
			home.clickOnLogoffIcon();
			home.clickOnLogofLink();
			login.clickOnLoginAgainLink();
		} else if (result.equalsIgnoreCase("invalid")) {
			System.out.println(username + "," + password + "," + result);

			login.enterCredential(username, password);

			extentTest.log(Status.INFO, "Entered value is : " + result);

			login.clickLoginButton();

			ut.verifyInnerText(login.getInvalidloginmassageINT(), AppConstant.invalid_credential_error_massage);

		}

	}

}
