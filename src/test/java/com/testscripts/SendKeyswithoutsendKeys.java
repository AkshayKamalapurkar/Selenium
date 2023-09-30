package com.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageobjects.Lambdatest;

import core.utils.InitiateBrowser;

public class SendKeyswithoutsendKeys {

	public WebDriver driver = InitiateBrowser.startBrowser();

	public Lambdatest lld = new Lambdatest(driver);

	@Test
	public void practiseMultipleMethodsinSelenium() throws Exception {
		InitiateBrowser.initialiseBrowserAndPassData1(driver);
		lld.generateStaleElement();
	
	}

}
