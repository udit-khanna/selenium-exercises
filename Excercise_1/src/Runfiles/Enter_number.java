package Runfiles;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Enter_number {
	private static final String inputPhoneNumber = "//*[@class='input-container _3udlq _22ixJ undefined']/input";
	private static final String phoneNumberMessage = "//*[@id='op_loader']/following-sibling::span[2]";
	private static final String inputPhoneNumber_NumEntered = "//*[@class='input-container _3udlq _22ixJ error']/input";
	private static final String phoneNumType = "//*[@name='dataCardType']/parent::label/span[1]";
	private static final String proceedButton = "//*[@class='btn _2eaVn']";
	private static final String operatorDropdown = "//*[@name='operator']";
	private static final String operatorDropdown_options = "//*[@name='operator']/option";
	private static final String circleDropdown = "//*[@name='circle']/option";
	private static final String amountField = "//*[@name='amount']";
	private static final String viewAllButton = "//*[@class='_3G6A5']";
	private static final String recommendedPlans = "//*[@class='_3Ek1g']/ul/li";
	private static final String recommendedPlans_Details = "//*[@class='_3Ek1g']/ul/li/div/p[2]";

	public void enterNumber(WebDriver driver, String data) {
		try {
			driver.findElement(By.xpath(inputPhoneNumber)).sendKeys(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printErrorMessage(WebDriver driver) {
		try {
			hoverOver(driver, inputPhoneNumber_NumEntered);
			if (driver.findElement(By.xpath(phoneNumberMessage)) != null) {
				String errorMessage = driver.findElement(By.xpath(phoneNumberMessage)).getText();
				if (errorMessage.equals(null)) {
					System.out.println("Entered number is valid.");
				} else {
					System.out.println("Error message for the number entered: " + errorMessage);
				}
			} else {
				System.out.println("Entered number is valid.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hoverOver(WebDriver driver, String element) {
		try {
			System.out.println("Hovering over the element");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(element))).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearTextField(WebDriver driver) {
		try {
			driver.findElement(By.xpath(inputPhoneNumber)).clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void checkPhoneNumType(WebDriver driver){
	// try {
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public void clickButton(WebDriver driver, String xPath) {
		try {
			driver.findElement(By.xpath(xPath)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDefaultOperator(WebDriver driver) {
		try {
			// String currentOperator =
			// driver.findElement(By.xpath(operatorDropdown)).getText();
			Select currentOperator = new Select(driver.findElement(By.xpath(operatorDropdown)));
			String selectedValue = currentOperator.getFirstSelectedOption().getText();
			System.out.println("Current operator is:" + selectedValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getTotalOperators(WebDriver driver) {
		try {
			System.out.println(
					"Total number of Operators: " + driver.findElements(By.xpath(operatorDropdown_options)).size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAnOperator(WebDriver driver, String value) {
		try {
			List<WebElement> operatorTypes = new ArrayList<WebElement>();
			operatorTypes = driver.findElements(By.xpath(operatorDropdown_options));
			clickButton(driver, operatorDropdown);
			for (WebElement w : operatorTypes) {
				if (w.getText().equalsIgnoreCase(value))
					w.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickNextButton(WebDriver driver) {
		try {
			clickButton(driver, proceedButton);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkAmountField(WebDriver driver) {
		try {
			if (driver.findElement(By.xpath(amountField)).getText().equalsIgnoreCase(null)) {
				System.out.println("Amount field is empty");
			} else {
				System.out.println("Amount field is not empty");
			}
		} catch (Exception e) {
			e.printStackTrace();
			}
	}

	public void clickViewAllButton(WebDriver driver) {
		clickButton(driver, viewAllButton);
	}

	public void getTotalRecommendedPlans(WebDriver driver) {
		try {
			List<WebElement> totalPlans = new ArrayList<WebElement>();
			totalPlans = driver.findElements(By.xpath(recommendedPlans));
			System.out.println("Total Recommended Plans are: " + totalPlans.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectEffectivePlan(WebDriver driver) {
		try {
			List<WebElement> totalPlans = new ArrayList<WebElement>();
			totalPlans = driver.findElements(By.xpath(recommendedPlans_Details));
			for(WebElement w: totalPlans){
				if(w.getText().contains("Full Talktime")){
					w.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
