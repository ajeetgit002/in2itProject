package com.in2it.cats_itsm.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException {

		String path = ".\\TestData\\credentials.xlsx";

		XLUtility xl = new XLUtility(path);

		int rowcount = xl.getRowCount("data");

		int colcount = xl.getCellCount("data", 1);

		String data[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {

			for (int j = 0; j < colcount; j++) {
				data[i - 1][j] = xl.getCellData("data", i, j);
			}
		}

		return data;

	}

	@DataProvider(name = "UserNames")
	public String[] getUserName() throws IOException {

		String path = System.getProperty("user.dir") + "\\testData\\UserData.xlsx";
		XLUtility xl = new XLUtility(path);

		int rowcount = xl.getRowCount("Sheet1");

		String apidata[] = new String[rowcount];

		for (int i = 1; i <= rowcount; i++) {
			apidata[i - 1] = xl.getCellData("Sheet1", i, 1);
		}
		return apidata;
	}

}
