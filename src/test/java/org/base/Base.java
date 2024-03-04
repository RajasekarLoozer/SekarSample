package org.base;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	 protected static WebDriver driver;

	public static void browser(String browser) {
		 driver = new ChromeDriver();
	}

	public static void urlLaunch(String url) {
		 driver.get(url);
	}

	public static void maximize() {
		driver.manage().window().maximize();

	}

	public static String excel(String path, String sheetname, int rownumber, int cellnumber) throws IOException {
		FileInputStream inputStream = new FileInputStream(path);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownumber);
		Cell cell = row.getCell(cellnumber);
		DataFormatter formatter = new DataFormatter();
		String formatCellValue = formatter.formatCellValue(cell);
		return formatCellValue;

	}

	public static WebElement passvalue(WebElement element, String value) {
		element.sendKeys(value);
		return element;
	}

	public static void click(WebElement element) {
		element.click();
	}

}
