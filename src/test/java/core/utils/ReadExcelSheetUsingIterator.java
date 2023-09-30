package core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetUsingIterator {

	protected static XSSFWorkbook wb;

	public static void readExcel() throws Exception {
		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "//resources//testData.xlsx"));
		wb = new XSSFWorkbook(fis);
	}

	public static void getDetails() { // pass parameter

		XSSFSheet sh = wb.getSheet("Sheet1");
		Iterator<Row> rowIterator = sh.rowIterator();
		rowIterators(rowIterator);
	}

	public static void rowIterators(Iterator<Row> rowIterator) {
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (row.getRowNum() == 0) {
				continue;
			}
			Iterator<Cell> colIterator = row.cellIterator();
			readColumnandBuildIterator(colIterator);
		}
	}

	public static void readColumnandBuildIterator(Iterator<Cell> colIterator) {

		while (colIterator.hasNext()) {
			String cellValue = null;
			Cell cell = colIterator.next();
			switch (cell.getCellType()) {

			case NUMERIC:
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			case STRING:
				cellValue = cell.getStringCellValue();
				break;
			case BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case FORMULA:
				cellValue = cell.getCellFormula();
			case BLANK:
				cellValue = "BLANK";
			default:
				cellValue = "DEFAULT";

			}
		}
	}

}
