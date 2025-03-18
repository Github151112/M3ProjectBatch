package com.Demowebshop.genericLib;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest implements IAutoConstant {

	public DataUtility d = new DataUtility();
	public FileUtility f = new FileUtility();
	public WebDriver driver;

	@BeforeSuite
	public void toConnectServer() {
		Reporter.log("==server connected sucessfully==", true);
	}

	@BeforeTest
	public void toConnectDatabase() {
		Reporter.log("==database connected successfully", true);
	}

	@BeforeClass
	public void setup() {
		String browser = f.getDataFromProperty(PROP_PATH, "browser");
		String url = f.getDataFromProperty(PROP_PATH, "url");
		Reporter.log("==Launching "+browser+" Browser==",true);
		driver = d.launchBrowser(browser);
		d.maximizeBrowser(driver);
		d.implicitWait(driver, 20);
		d.launchApplication(driver, url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("browser closed successfully",true);
	}

	@AfterTest
	public void toCloseDatabase() {
		Reporter.log("==database closed successfully==", true);
	}

	@AfterSuite
	public void toCloseServer() {
		Reporter.log("==server closed successfully==", true);
	}
}
