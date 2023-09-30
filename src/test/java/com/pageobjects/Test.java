package com.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test {
	public WebDriver driver;
	public Test(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="")
	@CacheLookup
	public WebElement path;
	
	public void TestWaits()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.stalenessOf(path));
		
		//FluentWait
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(2000))
				.pollingEvery(Duration.ofSeconds(222))
				.ignoring(NoSuchElementException.class);
		
		fwait.until(ExpectedConditions.visibilityOf(path));
		
		
	}

	
}
