package com.testscripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessExecution {
	
	public static void main(String[] args) {
		//pass this opt reference type to driver instance
				//example 
				//WebDriver driver = new ChromeDriver(opt);
		
				
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--disable-notifications");
				opt.addArguments("headless");
				WebDriver driver = new ChromeDriver(opt);
				
				WebDriverManager.chromedriver().setup();
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
			    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); 
			    
			    driver.get("https://www.amazon.in/");
				driver.navigate().refresh();
				System.out.println("PAss");
	}

}
