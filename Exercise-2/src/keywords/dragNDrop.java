package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class dragNDrop {
	private static final String draggableElement = "//*[@id='draggable']";

	public void dragAndDrop(WebDriver driver, int x, int y){
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(driver.findElement(By.xpath(draggableElement)), x, y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
