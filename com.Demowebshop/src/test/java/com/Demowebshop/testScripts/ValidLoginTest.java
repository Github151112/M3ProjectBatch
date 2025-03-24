package com.Demowebshop.testScripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Demowebshop.genericLib.BaseTest;
import com.Demowebshop.genericLib.CustomListener;

import objectRepository.SigninPage;
import objectRepository.WelcomePage;

@Listeners(CustomListener.class)
public class ValidLoginTest extends BaseTest {

	@Test(groups = {"ST","IT","FT","RT"})
	public void login() throws InterruptedException {

		// click on login link
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		/*
		 * using hard assert
		 */
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login","Login page is displayed");

		// login operation
		SigninPage sip = new SigninPage(driver);
		sip.toSignIn("singh001@gmail.com", "123456");

		//validate user is successfully logged in or not
		Assert.assertEquals(sip.getLogoutLink().isDisplayed(), true,"Logged in successfully");

	}

}
