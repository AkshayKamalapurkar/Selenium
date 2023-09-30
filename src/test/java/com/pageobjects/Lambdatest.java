package com.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lambdatest {
	
	public WebDriver driver;
	// public GlobalConstants constants;

	public Lambdatest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//a[normalize-space()='Table Data Search']")
	private WebElement tableSearch;
	
	@FindBy(xpath="//input[@id='task-table-filter']")
	private WebElement tableFilter;
	
	public void generateStaleElement()
	{
		tableSearch.click();
		tableFilter.sendKeys("Completed");
		driver.navigate().back();
		
		
		try {
			tableSearch.click();
		}
		catch (Exception e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.stalenessOf(tableSearch));
		}
	}
	
	public void sendKeyswithJS()
	{
		tableSearch.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//calling the method 
		js.executeScript("document.getElementById('tableFilter').value='Avinash Mishra';");
		
	}
	
	
	

	
	


}
