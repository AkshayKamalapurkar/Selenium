package com.testscripts;

import org.testng.annotations.Test;

import core.utils.DataProviderExample;

public class ParallelExecution {

	//public WebDriver driver = InitiateBrowser.startBrowser();

	//public PractisePage pg = new PractisePage(driver);
	
	@Test(dataProvider="xyx",dataProviderClass = DataProviderExample.class)
	public void test1(String fname,String lname)
	{
		String name1 = fname;
		String name2= lname;
		System.out.println(name1+" "+name2);
	}
	
	@Test
	public void test2()
	{
		
	}
	
	
}
