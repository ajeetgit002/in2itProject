package com.in2it.cats_itsm.basetest;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.in2it.cats_itsm.pages.HomePage;
import com.in2it.cats_itsm.utilities.WebUtil;
import com.in2it.cats_itsm.utilities.WebUtil.BrowserType;

public class BaseTest {

	protected WebUtil ut = WebUtil.getInstance();;
	protected Properties prop;
	protected WebDriver driver;

	protected ExtentTest extentTest;

	protected HomePage home;

	@BeforeSuite(alwaysRun = true)
	public void initExtentReport() {

		ut.createExtentReport("CATS_ITSM");
	}

	@BeforeClass(alwaysRun = true)
	public void setup() {
		prop = ut.init_prop("config");
		driver = ut.getDriver(BrowserType.valueOf(prop.getProperty("browser").toUpperCase()));
		ut.implicityWaitSecond(30);
		ut.maximize();
		ut.openUrl(prop.getProperty("url"));
		ut.threadWait(5000);
		home = new HomePage(ut, driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod_Setup(Method mt) {
		extentTest = ut.createTestReport(mt.getName());

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod_teardown(ITestResult result) {

		String[] groups = result.getMethod().getGroups();
		for (String group : groups) {
			ut.addtags(group);
		}
		if (result.getStatus() == ITestResult.FAILURE) {
		    extentTest.createNode(result.getName());
		    extentTest.assignCategory(result.getMethod().getGroups());
		    extentTest.log(Status.FAIL, "Test Failed");
		    extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		}
		ut.flushReport();

	}

	@AfterClass(alwaysRun = true)
	public void teardown() {
		ut.tearDown_Quit();

	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {

		ut.flushReport();
		System.out.print("******************Test  Suit excution is Done******************************");

	}
}
