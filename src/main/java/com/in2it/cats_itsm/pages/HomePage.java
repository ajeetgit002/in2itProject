package com.in2it.cats_itsm.pages;

import org.openqa.selenium.WebDriver;

import com.in2it.cats_itsm.pagesOR.HomePageOR;
import com.in2it.cats_itsm.utilities.WebUtil;

public class HomePage extends HomePageOR {
	WebUtil ut;

	public HomePage(WebUtil ut, WebDriver driver) {
		super(driver);
		this.ut = ut;

	}

	public void clickOnLogoffIcon() {
		ut.click(getLogofficonBT());
	}

	public void clickOnLogofLink() {
		ut.click(getLogoffLK());
	}

}
