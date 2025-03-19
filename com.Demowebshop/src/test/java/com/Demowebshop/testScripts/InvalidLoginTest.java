package com.Demowebshop.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Demowebshop.genericLib.BaseTest;
import com.Demowebshop.genericLib.ExcelUtility;

import net.bytebuddy.build.ToStringPlugin.Exclude;
import objectRepository.SigninPage;
import objectRepository.WelcomePage;

public class InvalidLoginTest extends BaseTest {

	@DataProvider(name = "InvalidData")
	public Object[][] multipleInvalidData() throws EncryptedDocumentException, IOException {

		return ExcelUtility.getMultipleData(EXCEL_PATH, INVALIDSHEET);
	}

	@Test(dataProvider = "InvalidData")
	public void invalidTest(String username, String password) {

		// click on login
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		// perform login
		SigninPage sip = new SigninPage(driver);
		sip.toSignIn(username, password);
	}

}
