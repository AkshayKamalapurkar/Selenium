package com.testscripts;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageobjects.PractisePage;

import core.utils.InitiateBrowser;

public class Runner {

	public WebDriver driver = InitiateBrowser.startBrowser();

	public PractisePage pg = new PractisePage(driver);

	@Test
	public void practiseMultipleMethodsinSelenium() throws Exception {
		InitiateBrowser.initialiseBrowserAndPassData(driver);
		// InitialiseMethods.initialiseBrowserAndPassData(driver);
		pg.checkPageValue();
		pg.rdoBtnCars();
		pg.chckBoxCars();
		pg.SwitchWindowExample();
		pg.SwitchTabExample();
		pg.selectClassExample();
		pg.selectAlertExample();
		pg.WebTable();
		pg.IframeExample();
		pg.jsExecutorExample();
		
	}

}
