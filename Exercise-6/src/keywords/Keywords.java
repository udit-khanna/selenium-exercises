package keywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Keywords {

	private static final String source = "//*[@id='draggableview']";
	private static final String destination = "//*[@id='droppableview']";
	private static final String dropDown = "//*[@id='menu-item-33']";
	private static final String dropDownOptions = "//*[@id='menu-item-33']/ul/li";
	private static final String verifyNewPage = "//*[@id='post-95']/header/h1";


	public void dragAndDrop(WebDriver driver) {
		try {
			WebElement srcElement = driver.findElement(By.xpath(source));
			WebElement destElement = driver.findElement(By.xpath(destination));
			Actions action = new Actions(driver);
			action.dragAndDrop(srcElement, destElement).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectDropdownOption(WebDriver driver) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(dropDown))).build().perform();
			List<WebElement> elements = new ArrayList<>(driver.findElements(By.xpath(dropDownOptions)));
			elements.get(2).click();
			if(driver.findElement(By.xpath(verifyNewPage)).getText().equalsIgnoreCase("iPads"))
				System.out.println("Element on dropdown clicked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
