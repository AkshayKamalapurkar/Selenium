package core.utils;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
public class ReadExcel2Test {
    public static void main(String[] args) throws IOException {
        ReadExcel2 ex = new ReadExcel2(System.getProperty("user.dir") + "//resources//testData.xlsx", 0);
        Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
      // System.out.println("Excel Data for 2nd row and column- AccountNo : "+excelData.get("Name"));
       System.out.println("excelData as Map: "+excelData);
        String value = excelData.get("1").get("Url").toString();
        System.out.println(value);
    }
    
    @BeforeClass
    public static Map<String, Map<String, String>> readExcelSheet() throws IOException
    {
    	 ReadExcel2 ex = new ReadExcel2(System.getProperty("user.dir") + "//resources//testData.xlsx", 0);
         Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
         return excelData;
  }
}
