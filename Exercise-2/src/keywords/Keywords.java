package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Keywords {
	private static final String draggableElement = "//*[@id='draggable']";
	private static final String loginButton = "//*[@id='ch_login_icon']/span[2]";
	private static final String googleButton = "//*[@id='ch_login_google']";
	private static final String verifytextElement = "//*[@class='hidden-small']";

	public void dragAndDrop(WebDriver driver, int x, int y) {
		try {
			Actions action = new Actions(driver);
			action.dragAndDropBy(driver.findElement(By.xpath(draggableElement)), x, y);
			action.build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchFrame(WebDriver driver, String verifytext) {
		try {
			String winHandleBefore = driver.getWindowHandle();

			driver.findElement(By.xpath(loginButton)).click();
			driver.findElement(By.xpath(googleButton)).click();

			// Switch to new window opened
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
			}
			String actualText = driver.findElement(By.xpath(verifytextElement)).getText();

			if (actualText.equalsIgnoreCase(verifytext))
				System.out.println("Actual Text: " + actualText + " matches expected text: " + verifytext);
			else
				System.out.println("Actual Text: " + actualText + " does not match expected text: " + verifytext);

			// Close the new window, if that window no more required
			driver.close();

			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);

			// Continue with original browser (first window)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
