package com.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import core.utils.InitiateBrowser;

public class HandlingSSLCertificates {

	//public WebDriver driver = InitiateBrowser.startBrowser();
	
	
		@Test
		public void practiseMultipleMethodsinSelenium() throws Exception {
			ChromeOptions handlingSSL = new ChromeOptions();
			
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);
			
			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			WebDriver driver = new ChromeDriver(handlingSSL);
			
			driver.get("https://expired.badssl.com/");
			//InitiateBrowser.initialiseBrowserAndPassData2(driver);
			//Create instance of ChromeOptions Class
		
			
		}
	

}
