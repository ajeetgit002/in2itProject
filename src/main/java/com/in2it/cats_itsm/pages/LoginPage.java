package com.in2it.cats_itsm.pages;

import org.openqa.selenium.WebDriver;

import com.in2it.cats_itsm.pagesOR.LoginPageOR;
import com.in2it.cats_itsm.utilities.WebUtil;

public class LoginPage extends LoginPageOR {

	private WebUtil ut;

	public LoginPage(WebUtil ut, WebDriver driver) {
		super(driver);
		this.ut = ut;
	}

	public void enterCredential(String username, String password) {

		ut.sendkey(getUsernameTB(), username);
		ut.sendkey(getPasswordTB(), password);

	}

	public void clickLoginButton() {

		ut.click(getLoginBT());

	}

	public void clickOnLoginAgainLink() {
		ut.click(getLoginagainLK());
	}

}
