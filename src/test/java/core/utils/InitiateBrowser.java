package core.utils;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InitiateBrowser {

	public static WebDriver driver;
	

	public static WebDriver startBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); 
		return driver;
	}
	
	
	public static void initialiseBrowserAndPassData(WebDriver driver) throws IOException {
		Map<String, Map<String, String>> excel = ReadExcel2Test.readExcelSheet();
		 String value = excel.get("1").get("Url").toString();
	      driver.get(value);
	}
	
	public static void initialiseBrowserAndPassData1(WebDriver driver) throws Exception {
		Map<String, Map<String, String>> excel = ReadExcel2Test.readExcelSheet();
		 String value = excel.get("2").get("Url").toString();
	      driver.get(value);
	    
	}
	public static void initialiseBrowserAndPassData2(WebDriver driver) throws Exception {
		Map<String, Map<String, String>> excel = ReadExcel2Test.readExcelSheet();
		 String value = excel.get("3").get("Url").toString();
	      driver.get(value);
	    
	}
	public static void initialiseBrowserAndPassData4(WebDriver driver) throws Exception {
		Map<String, Map<String, String>> excel = ReadExcel2Test.readExcelSheet();
		 String value = excel.get("4").get("Url").toString();
	      driver.get(value);
	    
	}
}
