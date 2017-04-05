package keywords;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Keywords2 {

	private static final String dragObject = "//*[@id='draggable']";
	private static final String newWindowButton = "//*[@id='button1']";
	private static final String newWindowText = "//*[@id='slide-16-layer-1']";
	private static final String timerAlertButton = "//*[@id='timingAlert']";

	public void dragAndDrop(WebDriver driver, int x, int y) {
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(driver.findElement(By.xpath(dragObject)), x, y).build().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchFrame(WebDriver driver, String text) {
		try {
			String winHandleBefore = driver.getWindowHandle();
			driver.findElement(By.xpath(newWindowButton)).click();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			driver.manage().window().maximize();
			String actualText = driver.findElement(By.xpath(newWindowText)).getText().trim();
			if (actualText.equalsIgnoreCase(text))
				System.out.println("Actual Text: '" + actualText + "' matches expected: '" + text +"'");
			else
				System.out.println("Actual Text: '" + actualText + "' does not match expected: '" + text +"'");

			driver.close();
			driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void timerAlert(WebDriver driver) {
		try {
			driver.findElement(By.xpath(timerAlertButton)).click();
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
