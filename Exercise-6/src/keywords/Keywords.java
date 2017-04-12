package keywords;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
	private static final String enterField = "lst-ib";
	private static final String iFrame = "iframeResult";
	private static final String chooseFileButton = "//*[@name='pic']";
//	private static final CharSequence filePath = System.getProperty("user.dir") + "\\lib\\cglib-nodep-3.2.4.jar";


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

	public void enterText(WebDriver driver, String textToEnter) {
		try {
			driver.findElement(By.id(enterField)).sendKeys(textToEnter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void highlightEnteredText(WebDriver driver, String textToEnter) {
		try {
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("document.getElementById('" + enterField + "').style.border='2px solid green';");
			driver.findElement(By.id(enterField)).click();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.HOME).build().perform();
			action.keyDown(Keys.LEFT_SHIFT);
			int textLength = textToEnter.length();
			for(int i=0; i< textLength; i++){
				action.sendKeys(Keys.ARROW_RIGHT);
			}
			action.keyUp(Keys.LEFT_SHIFT);
//			action.sendKeys(Keys.BACK_SPACE);
			action.build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rightClickAndCut(WebDriver driver) {
		try {
			WebElement element = driver.findElement(By.id(enterField));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).contextClick(element);
			
//			.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN);			// does not work on chrome
			actions.build().perform();
			Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickChooseFileButton(WebDriver driver) {
		try {
			driver.switchTo().frame(iFrame);
			driver.findElement(By.xpath(chooseFileButton)).click();
//			Actions actions = new Actions(driver);
//			actions.sendKeys(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendFilePath(WebDriver driver, String filePath) {
		try {
//			Actions actions = new Actions(driver);
//			actions.sendKeys(filePath);
//			actions.sendKeys(Keys.RETURN);
			
			
//			Copy your file's absolute path to the clipboard
			StringSelection ss = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//			Paste the file's absolute path into the File name field of the File Upload dialog box
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath(chooseFileButton)).sendKeys(filePath);
			driver.findElement(By.xpath(chooseFileButton)).sendKeys(Keys.RETURN);

			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
