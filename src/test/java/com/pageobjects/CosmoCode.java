package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class CosmoCode {
	public WebDriver driver;
	// public GlobalConstants constants;

	public CosmoCode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Fetch Row
	@FindBy(xpath = "//table[@id=\"countries\"]/tbody/tr")
	private List<WebElement> tableRows;

	// Fetch column
	@FindBy(xpath = "//*[@id=\"countries\"]/tbody/tr[1]/td")
	private List<WebElement> tableCols;
	
	
	public void fetchRowsColumns()
	{
		for(int i=1;i<tableRows.size();i++)
		{
			for(int j=1;j<tableCols.size();j++)
			{
				String value =driver.findElement(By.xpath("//table[@id=\"countries\"]/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.println(value);
			}
		}
	}
	
}
