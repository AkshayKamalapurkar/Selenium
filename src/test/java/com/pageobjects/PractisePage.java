package com.pageobjects;

import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.binding.GlobalConstants;

public class PractisePage {
	public WebDriver driver;
	// public GlobalConstants constants;

	public PractisePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "bmwradio")
	@CacheLookup
	private WebElement rdoBtn;

	// First Approach
	By myLocator = By.id("data-uniqid");

	// Second Approach
	@FindBy(xpath = "//h1[@data-uniqid='1621702280245']")
	@CacheLookup
	private WebElement practisePage;

	@FindBy(xpath = "//div[@id=\"radio-btn-example\"]/fieldset/label/input[@name=\"cars\"]")
	@CacheLookup
	private List<WebElement> rdoBtns;

	@FindBy(xpath = "//div[@id=\"open-window-example-div\"]/fieldset/button")
	@CacheLookup
	private WebElement SwitchWindow;

	@FindBy(xpath = "//div[@id=\"open-tab-example-div\"]/fieldset/a")
	@CacheLookup
	private WebElement SwitchTab;

	@FindBy(xpath = "//a[@href='/login']")
	@CacheLookup
	private WebElement btnLoginChildWindow;

	// div[@id="radio-btn-example"]/fieldset/label/input[@name="cars"]

	@FindBy(xpath = "//div[@id=\"checkbox-example-div\"]/fieldset/label/input[@name=\"cars\"]")
	@CacheLookup
	private List<WebElement> chckBx;

	@FindBy(xpath = "//select[@id=\"carselect\"]")
	@CacheLookup
	private WebElement selectClassExample;

	@FindBy(xpath = "//div[@id=\"alert-example-div\"]/fieldset/input[@id=\"name\"]")
	@CacheLookup
	private WebElement enterYourName;

	// div[@id="alert-example-div"]/fieldset/input[@id="alertbtn"]

	@FindBy(xpath = "//div[@id=\"alert-example-div\"]/fieldset/input[@id=\"name\"]")
	@CacheLookup
	private WebElement lblAlert;

	@FindBy(xpath = "//div[@id=\"alert-example-div\"]/fieldset/input[@id=\"alertbtn\"]")
	@CacheLookup
	private WebElement btnAlert;

	@FindBy(xpath = "//div[@id=\"alert-example-div\"]/fieldset/input[@id=\"confirmbtn\"]")
	@CacheLookup
	private WebElement btnConfirm;

	@FindBy(xpath = "//table[@id=\"product\"]/tbody/tr")
	@CacheLookup
	private List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id=\"product\"]/tbody/tr[1]/th")
	@CacheLookup
	private List<WebElement> tableColumn;

	@FindBy(xpath="//button[@id=\"mousehover\"]")
	@CacheLookup
	private WebElement mOver;
	
	@FindBy(xpath="//*[@id=\"mouse-hover-example-div\"]/div[1]/fieldset/div/div/a[2]")
	@CacheLookup
	private WebElement mOverTarget;
	
	@FindBy(xpath="//iframe[@id=\"courses-iframe\"]")
	@CacheLookup
	private WebElement iframeId;
	
	@FindBy(xpath="//h4[contains(text(),'JavaScript')]")
	@CacheLookup
	private WebElement courseJavaScriptId;
	
	public void checkPageValue() {
		String value = practisePage.getText();
		System.out.println(value);
		GlobalConstants.softassertion.assertEquals(value, "Test", "Value matches?");
		// Assert.assertEquals(value, "PGG");
	}

	public List<String> getValuesfromList(List<WebElement> Value, String attributeValue, String valuetoCheck) {
		List<String> newls = new ArrayList<String>();
		for (WebElement ls : Value) {
			newls.add(ls.getAttribute(attributeValue));
			if (ls.getAttribute(attributeValue).equals(valuetoCheck)) {
				ls.click();
			}
		}
		return newls;
	}

	public void rdoBtnCars() {
		getValuesfromList(rdoBtns, "value", "benz");
	}

	public void chckBoxCars() {
		getValuesfromList(chckBx, "value", "bmw");
	}

	public void SwitchWindowExample() {
		SwitchWindow.click();
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> s1 = allWindowHandles.iterator();
		while (s1.hasNext()) {
			String childWindow = s1.next();
			if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				btnLoginChildWindow.click();
				// perform operation
			}
		}

	}

	public void SwitchTabExample() {
		SwitchTab.click();
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> s1 = allWindowHandles.iterator();
		while (s1.hasNext()) {
			String childWindow = s1.next();
			if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				btnLoginChildWindow.click();
				// perform operation
			}
		}
	}

	public void selectClassExample() {
		Select sel = new Select(selectClassExample);
		sel.selectByValue("honda");
	}

	public void selectAlertExample() {
		lblAlert.sendKeys("Akk");
		btnAlert.click();

		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		if (alertMessage.contains("kk")) {
			System.out.println("Pass");
		}
		alert.accept();
	}

	public void WebTable() {
		int rowSize = tableRows.size();
		System.out.println(rowSize);
		int colSize = tableColumn.size();
		System.out.println(colSize);

		for (int i = 1; i < rowSize; i++) {
			for (int j = 1; j <= colSize; j++) {
				String newValue = driver
						.findElement(By.xpath("//table[@id=\"product\"]/tbody/tr[" + (i + 1) + "]/td[" + j + "]"))
						.getText();
				System.out.println(newValue);
			}

		}

	}

	public void MouseHoverExample() {
		Actions actn = new Actions(driver);
		actn.moveToElement(mOver).perform();
		actn.moveToElement(mOverTarget).perform();
		actn.moveToElement(mOverTarget).click();
		actn.build().perform();
		
	}
	
	public void IframeExample() {
		boolean flag;
		if(iframeId.isDisplayed())
		{
			driver.switchTo().frame(iframeId);
			flag = true;
			courseJavaScriptId.click();
		}
	}
	public void jsExecutorExample()
	{
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		
		String text = obj.executeScript("return document.title").toString();
		System.out.println(text);
		
		// Scroll Down by 500 pixels
		obj.executeScript("window.scrollBy(0,500)", "");
		
		// Scroll Down till the bottom of the page
		obj.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//Generate Alert window 
		obj.executeScript("alert('Welcome to Js Executor Testing Method');"); 
		
		 
	}

}
