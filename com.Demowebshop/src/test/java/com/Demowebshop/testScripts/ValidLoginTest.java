package com.Demowebshop.testScripts;

import org.testng.annotations.Test;

import com.Demowebshop.genericLib.BaseTest;

import objectRepository.SigninPage;
import objectRepository.WelcomePage;

public class ValidLoginTest extends BaseTest {

	@Test
	public void login() throws InterruptedException {

		// click on login link
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();

		// login operation
		SigninPage sip = new SigninPage(driver);
		sip.toSignIn("hdsdcb@gmail.com", "cbdgycdf");

		Thread.sleep(2000);

	}

}
