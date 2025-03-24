package com.Demowebshop.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Demowebshop.genericLib.BaseTest;
import com.Demowebshop.genericLib.ExcelUtility;

import objectRepository.RegisterPage;
import objectRepository.WelcomePage;

public class RegisterTest extends BaseTest {

	@DataProvider(name = "registerData")
	public Object[][] registerData() throws EncryptedDocumentException, IOException {
		return ExcelUtility.getMultipleData(EXCEL_PATH, REGSHEET);
	}

	@Test(dataProvider = "registerData",groups = "ST")
	public void register(String firstName, String lastName, String password) throws InterruptedException {

		// click on register link
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		
		/*
		 * use soft Assert
		 */
		SoftAssert s = new SoftAssert();
		s.assertEquals(driver.getTitle(),"Demo Web Shop. Register","Register page is displayed");

		// perform register
		RegisterPage rp = new RegisterPage(driver);
		rp.toRegisterInDemoWebShop(firstName, lastName, d.randomEmailId(), password);
		Thread.sleep(3000);
		
		s.assertEquals(rp.getContinueButton().isEnabled(), true,"Registraion successfully");
		
		s.assertAll();

	}

}
