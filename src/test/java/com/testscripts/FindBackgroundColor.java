package com.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBackgroundColor {

	public WebDriver driver;

	@Test
	public void bgColour() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.manage().window().maximize();
		
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Savings up to ₹14,000')]"));
		String bgcolour = ele.getCssValue("color");
		String hexaColour = Color.fromString(bgcolour).asHex();
		
		System.out.println(bgcolour);
		System.out.println(hexaColour);
		
		
	}
}
