package com.in2it.cats_itsm.pagesOR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

@Getter
public class HomePageOR {

	private WebDriver ldriver;

	public HomePageOR(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//span[@class='truncate']")
	private WebElement welcomeINT;

	@FindBy(xpath = "//span[@id='logOffBtn']")
	private WebElement logofficonBT;

	@FindBy(xpath = "//a[text()='Log off']")
	private WebElement logoffLK;
}
