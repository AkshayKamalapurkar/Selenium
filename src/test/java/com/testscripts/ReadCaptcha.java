package com.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class ReadCaptcha {

	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
		
		driver.findElement(By.xpath("//a[contains(text(),' LOGIN ')]")).click();
		Thread.sleep(2000);
		File src = driver.findElement(By.xpath("//div[@class='captcha_div']/span/img")).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/captcha.png";
		
		FileUtils.copyFile(src, new File(path));
		
		ITesseract image = new Tesseract();
		String irctPage = image.doOCR(new File(path));
		System.out.println(irctPage);
		//hello how are you feature branch
		
		
		
		

		
	}
}
