package core.utils;

import org.testng.annotations.DataProvider;

public class DataProviderExample {
	
	@DataProvider(name="xyx")
	public Object[][] AllData()
	{
		return new Object[][] {{"Aks","Ash"},{"Kamla","Honn"}};
		
	}

}
