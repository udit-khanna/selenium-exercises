package Runfiles;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getBrandNames {
	static List<WebElement> Brands = new ArrayList<WebElement>();
	private static final String brand_xpath = "//*[@class='_3iLMi']/div/img";

	public void getBrands(WebDriver driver) {
		try {
			Brands = driver.findElements(By.xpath(brand_xpath));
			for (WebElement e : Brands) {
				System.out.println(e.getAttribute("alt"));
			}
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
