package com.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class HomePage extends BasePage{
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"logo\"]")
	@CacheLookup
	public WebElement storeLogo;
	
	@FindBy(xpath="//a[normalize-space()='Sign In'])[1]")
	@CacheLookup
	public WebElement btnSignIn;

	// nav[@class='navigation']
	// nav[@data-action="navigation"]/ul/li/a

	@FindBy(xpath = "//nav[@data-action=\"navigation\"]/ul/li/a")
	@CacheLookup
	public List<WebElement> menuItemList;

	public void verifyMenuItems() {
		List<String> newLs = new ArrayList<String>();
		Actions actions = new Actions(driver);

		for (WebElement we : menuItemList) {
			newLs.add(we.getText());

			actions.moveToElement(we).keyDown(Keys.COMMAND).click().keyUp(Keys.COMMAND).build().perform();
		}
		System.out.println(newLs);
	}

	public void verifyChildWindows() {
		String mainWindow = driver.getWindowHandle();
		Set<String> allchildWindows = driver.getWindowHandles();

		for (String windows : allchildWindows) {
			driver.switchTo().window(windows);
			System.out.println(" --- " + driver.getTitle());
		}
		driver.switchTo().window(mainWindow);
		System.out.println(driver.getTitle());

	}

	public void verifyWait() {
		// Selenium 3 - Implicit
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.visibilityOf(storeLogo));

		// Fluent wait
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(1000))
				.pollingEvery(Duration.ofSeconds(1000)).ignoring(NoSuchElementException.class);

		WebElement foo = wait1.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("foo"));
			}
		});

	}
	
	
	public void testOverridedFindElement()
	{
		
//		WebElement ele = WaitAndfindElement(btnSignIn);
//		System.out.println(ele.getText());
		
	}

	
}
