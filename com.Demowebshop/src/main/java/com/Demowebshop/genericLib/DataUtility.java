package com.Demowebshop.genericLib;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class DataUtility {

	/*
	 * this method will perform launching browser operation
	 */
	public WebDriver launchBrowser(String browser) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			Reporter.log("Invalid Browser", true);
		return driver;
	}

	/*
	 * this method will perform maximizing browser operation
	 */
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/*
	 * this method will perform implicit wait operation
	 */
	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	/*
	 * this method will perform launching application operation
	 */
	public void launchApplication(WebDriver driver, String url) {
		driver.get(url);
	}
	
	public String randomEmailId()
	{
		Random r  = new Random();
		int no = r.nextInt(10000);
		String email = "anoop"+ no+ "@gmail.com";
		return email;
	}

}
