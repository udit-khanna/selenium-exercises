package Runfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Enter_number {
	private static final String inputPhoneNumber = "//*[@class='input-container _3udlq _22ixJ undefined']/input";
	private static final String phoneNumberMessage = "//*[@id='op_loader']/following-sibling::span[2]";
	private static final String inputPhoneNumber_NumEntered = "//*[@class='input-container _3udlq _22ixJ error']/input";
	private static final String phoneNumType = "//*[@name='dataCardType']/parent::label/span[1]";
	
	
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
	
	public void hoverOver(WebDriver driver, String element){
		try{
			System.out.println("Hovering over the element");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(element))).click().build().perform();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void checkPhoneNumType(WebDriver driver){
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
