package com.in2it.cats_itsm.pagesOR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class LoginPageOR {

	private WebDriver rdriver;

	public LoginPageOR(WebDriver driver) {
		this.rdriver = driver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name='auth_user']")
	private WebElement usernameTB;

	@FindBy(xpath = "//input[@name='auth_pwd']")
	private WebElement passwordTB;

	@FindBy(xpath = "//div[@id='login-submit']//input")
	private WebElement loginBT;

	@FindBy(xpath = "//p[@class='hilite']")
	private WebElement invalidloginmassageINT;

	@FindBy(xpath = "//a[text()='Click here to login again...']")
	private WebElement loginagainLK;
}
