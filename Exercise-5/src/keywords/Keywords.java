package keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Keywords {

	private static final String inputNumberField = "//*[@class='input-container _3udlq _22ixJ undefined']/input";
	private static final String totalPlans = "//*[@class='_3Ek1g']/ul/li";
	private static final String planCostXpath = "//*[@class='_3Ek1g']/ul/li/p[1]";
	private static final String planDetailsXpath = "//*[@class='_3Ek1g']/ul/li/div/p[2]";
	private static final String validityXpath = "//*[@class='_3Ek1g']/ul/li/div/p[3]/span[2]";
	private static final String proceedButtonXpath = "//*[@class='_3A7E-']/button";
	private static final String viewAllXpath = "//*[@class='_3G6A5']";
	private static final String submitButton = ".btn._2eaVn";
	private static final String operatorDropdown = ".select-container.bR5l8.false > select";
	private static final String fileName = "Recommended Plans.xlsx";
	private static final CharSequence verifyText = "Full Talktime";
	private static ArrayList<String> planCost, planDetails, validity;
	private static ArrayList<ArrayList<String>> allData = new ArrayList<ArrayList<String>>();

	public void navigateToRecommendedPlans(WebDriver driver, String number) {
		try {
			driver.findElement(By.xpath(inputNumberField)).sendKeys(number);
			driver.findElement(By.cssSelector(operatorDropdown)).click();
			driver.findElement(By.cssSelector(submitButton)).click();
			Thread.sleep(1000);
			// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.findElement(By.xpath(viewAllXpath)).click();
			List<WebElement> elements = new ArrayList<>(driver.findElements(By.xpath(totalPlans)));
			List<WebElement> planCostElements = new ArrayList<>(driver.findElements(By.xpath(planCostXpath)));
			List<WebElement> planDetailsElements = new ArrayList<>(driver.findElements(By.xpath(planDetailsXpath)));
			List<WebElement> validityElements = new ArrayList<>(driver.findElements(By.xpath(validityXpath)));

			planCost = getTextOfAllElements(planCostElements);
			planDetails = getTextOfAllElements(planDetailsElements);
			validity = getTextOfAllElements(validityElements);

			allData.add(planCost);
			allData.add(planDetails);
			allData.add(validity);

			for (int count = 0; count < elements.size(); count++) {
				System.out.println(planCost.get(count));
				System.out.println(planDetails.get(count));
				System.out.println(validity.get(count));
				System.out.println(" ------------------------ ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getTextOfAllElements(List<WebElement> elements) {
		ArrayList<String> list = new ArrayList<>();
		try {
			for (WebElement e : elements) {
				list.add(e.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void writeDataToExcel(WebDriver driver) {
		try {
			Workbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("Recommended Plans Details");
			List<WebElement> elements = new ArrayList<>(driver.findElements(By.xpath(totalPlans)));
			for (int count = 0; count < elements.size(); count++) {
				Row newRow = sheet.createRow(count);
				for (int j = 0; j < 3; j++) {
					newRow.createCell(j).setCellValue(allData.get(j).get(count));
				}
			}
			File file = new File(System.getProperty("user.dir") + "\\Execution Results\\" + fileName);
			FileOutputStream inputStream = new FileOutputStream(file);
			workbook.write(inputStream);
			inputStream.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readExcelforFullTalktime(WebDriver driver) {
		try {
			File src = new File(System.getProperty("user.dir") + "\\Execution Results\\" + fileName);
			FileInputStream fis = new FileInputStream(src);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			// Iterating all the rows in the sheet
			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				row = (XSSFRow) rows.next();
				cell = row.getCell(1);
//				System.out.println(cell.getStringCellValue());
				if(cell.getStringCellValue().contains(verifyText)){
//					System.out.println(cell.getStringCellValue());
					font.setColor(IndexedColors.BLUE.getIndex());
		            style.setFont(font);
				}
			}
			fis.close();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
