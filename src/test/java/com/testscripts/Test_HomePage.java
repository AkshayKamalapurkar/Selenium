package com.testscripts;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pageobjects.HomePage;

import core.utils.InitiateBrowser;

public class Test_HomePage {
	public WebDriver driver = InitiateBrowser.startBrowser();
	HomePage hm = new HomePage(driver);
	
	@Test
	public void Tc_01() throws Exception
	{
		InitiateBrowser.initialiseBrowserAndPassData(driver);
		hm.verifyMenuItems();
		hm.verifyChildWindows();
		//checking again
	}
}
