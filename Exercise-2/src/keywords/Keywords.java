package keywords;

import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
	private static final String draggableElement = "//*[@id='draggable']";
	private static final String loginButton = "//*[@id='ch_login_icon']";
	private static final String googleButton = "//*[@id='ch_login_google']";
	private static final String verifytextElement = "//*[@class='hidden-small']";
	private static final String frameID = "iframeResult";
	private static final String dropdown = "//*[@contenteditable='false']/select";
	private static final String messageBox = "//*[@id='avia_message_1']";

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
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(googleButton)));
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
			e.printStackTrace();
		}
	}

	public void alertClose(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 18);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToFrame(WebDriver driver) {
		try {
			driver.switchTo().frame(frameID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getCurrentValue(WebDriver driver) {
		try {
			Select select = new Select(driver.findElement(By.xpath(dropdown)));
			System.out.println("Selected option is: " + select.getFirstSelectedOption().getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterRandomText(WebDriver driver) {
		try {
			String uuid = UUID.randomUUID().toString();
			driver.findElement(By.xpath(messageBox)).sendKeys(uuid);
			System.out.println("Entered text is: " + uuid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getStringInTextBox(WebDriver driver) {
		try {
			String enteredText = driver.findElement(By.xpath(messageBox)).getAttribute("value");
			System.out.println("Entered text length is: " + enteredText.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
