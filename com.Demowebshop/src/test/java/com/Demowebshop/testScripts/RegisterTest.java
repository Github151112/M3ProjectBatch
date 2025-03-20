package com.Demowebshop.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Demowebshop.genericLib.BaseTest;
import com.Demowebshop.genericLib.ExcelUtility;

import objectRepository.RegisterPage;
import objectRepository.WelcomePage;

public class RegisterTest extends BaseTest {

	@DataProvider(name = "registerData")
	public Object[][] registerData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.getMultipleData(EXCEL_PATH, REGSHEET);
	}

	@Test(dataProvider = "registerData")
	public void register(String firstName, String lastName, String password) throws InterruptedException {

		// click on register link
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();

		// perform register
		RegisterPage rp = new RegisterPage(driver);
		rp.toRegisterInDemoWebShop(firstName, lastName, d.randomEmailId(), password);
		Thread.sleep(3000);

	}

}
