package com.in2it.cats_itsm.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retrycount = 0;

	private final int maxRetry = 3;

	@Override
	public boolean retry(ITestResult result) {

		if (retrycount < maxRetry) {
			System.out.println("Retry :Due to Failled");
			retrycount++;
			return true;
		}
		return false;
	}
}
