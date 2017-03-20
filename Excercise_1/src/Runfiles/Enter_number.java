package Runfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Enter_number {
	private static final String inputPhoneNumber = "//*[@class='input-container _3udlq _22ixJ undefined']/input";
	
	public void enterNumber(WebDriver driver, String data){
		try{
			driver.findElement(By.xpath(inputPhoneNumber)).sendKeys(data);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
