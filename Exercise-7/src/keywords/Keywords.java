package keywords;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {

	private static final String inputNumberField = "//*[@class='input-container _3udlq _22ixJ undefined']/input";
	private static final String operatorField = "//*[@class='select-container bR5l8 false']/select/option";
	private static final String operatorDropdown = "//*[@class='select-container bR5l8 false']/select";
	private static final String proceedButton = "//*[@class='btn _2eaVn']";
	private static final long timeoutSec = 10;
	private static final String viewAllButton = "//*[@class='_3G6A5']";
	private static final String planOffers = "//*[@class='_3Ek1g']/ul/li";
	private static final String planOfferDetails = "//*[@class='_3Ek1g']/ul/li/div/p[2]";

	private static String selectedOperator;
	private static String selectedPlan;

	public void enterRandomNumber(WebDriver driver) {
		try {
			String randomPhone = (String) generateRandomPhoneNumber();
			driver.findElement(By.xpath(inputNumberField)).sendKeys(randomPhone);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CharSequence generateRandomPhoneNumber() {
		String randomNum = "9";
		try {
			Random rand = new Random();
			for (int i = 0; i < 9; i++)
				randomNum = randomNum + (rand.nextInt(9));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomNum;
	}

	public int randomNum(int maxLimit) {
		int randomNumber = 0;
		Random rand = new Random();
		try {
			randomNumber = rand.nextInt(maxLimit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomNumber;
	}

	public void selectRandomOperator(WebDriver driver) {
		try {
			ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(By.xpath(operatorField)));
			Thread.sleep(1000);
			driver.findElement(By.xpath(operatorDropdown)).click();
			// Thread.sleep(1000);
			int elementToClick = randomNum(elements.size());
			elements.get(elementToClick).click();
			selectedOperator = elements.get(elementToClick).getText();
			System.out.println("clicking operator: " + selectedOperator);
			// Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigatoToPlans(WebDriver driver) {
		try {
			driver.findElement(By.xpath(proceedButton)).click();
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(viewAllButton)));
			driver.findElement(By.xpath(viewAllButton)).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectRandomPlan(WebDriver driver) {
		try {
			ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(By.xpath(planOffers)));
			ArrayList<WebElement> planDetails= new ArrayList<>(driver.findElements(By.xpath(planOfferDetails)));
			ArrayList<String> planDetailsText= new ArrayList<>();

			int planToPick = randomNum(elements.size());
			Thread.sleep(1000);
			elements.get(planToPick).click();
			System.out.println("Plan Picked #" + planToPick + " : " + elements.get(planToPick));
			Thread.sleep(1000);
			for(WebElement e: planDetails){
				planDetailsText.add(e.getText());
				System.out.println(e.getText());
			}
			selectedPlan = planDetailsText.get(planToPick);
			System.out.println("Selected plan details: " + selectedPlan);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
