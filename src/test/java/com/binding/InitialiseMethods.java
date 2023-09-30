package com.binding;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import core.utils.ReadExcel2Test;

public class InitialiseMethods {
	
	public static void initialiseBrowserAndPassData(WebDriver driver) throws IOException {
		Map<String, Map<String, String>> excel = ReadExcel2Test.readExcelSheet();
		 String value = excel.get("1").get("Url").toString();
	      driver.get(value);
	}
	
//	public static void initialiseBrowserAndPassData1(WebDriver driver) throws Exception {
//		Map<String, Map<String, String>> excel = ReadExcel2Test.readExcelSheet();
//		 String value = excel.get("2").get("Url").toString();
//	      driver.get(value);
//	    
//	}
}
