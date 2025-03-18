package com.Demowebshop.testScripts;

import org.testng.annotations.Test;

import com.Demowebshop.genericLib.BaseTest;

import objectRepository.RegisterPage;
import objectRepository.WelcomePage;

public class RegisterTest extends BaseTest {

	@Test
	public void register() throws InterruptedException {
		
		//click on register link
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		
		//perform register
		RegisterPage rp = new RegisterPage(driver);
		rp.toRegisterInDemoWebShop("gydscy","sdygys","sdcbhsd@gmail.com","bcdhdd");
		Thread.sleep(3000);

	}

}
