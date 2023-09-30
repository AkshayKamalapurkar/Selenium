package com.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageobjects.CosmoCode;
import core.utils.InitiateBrowser;

public class DynamicTable {
	
public WebDriver driver = InitiateBrowser.startBrowser();
	
	public CosmoCode cc = new CosmoCode(driver);

	@Test
	public void practiseMultipleMethodsinSelenium() throws Exception {
		InitiateBrowser.initialiseBrowserAndPassData1(driver);
		cc.fetchRowsColumns();
	}

}
