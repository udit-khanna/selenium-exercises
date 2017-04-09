package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Keywords {

	private static final String messageBox = "//*[@name='avia_message_1']";

	public void navigateToUrl(JavascriptExecutor js, String url) {
		try {
			js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void enterTextInMsgBox(WebDriver driver, JavascriptExecutor js, String enteredtext) {
		try {
			System.out.println("Entering text in message box: " + enteredtext);
			js.executeScript("arguments[0].value='" + enteredtext + "'", driver.findElement(By.xpath(messageBox)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getMessageBoxText(JavascriptExecutor js) {
		try {
			String enteredText = js.executeScript("return document.getElementById('avia_message_1').value").toString();
			System.out.println("Entered text in message box: " + enteredText);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public void changeTextMessageBox(JavascriptExecutor js, String changedtext) {
		try {
			js.executeScript("document.getElementById('avia_message_1').value=''");
			js.executeScript("document.getElementById('avia_message_1').value='" + changedtext + "'");
			String enteredText = js.executeScript("return document.getElementById('avia_message_1').value").toString();
			System.out.println("Text after changing: " + enteredText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loginToFb(WebDriver driver, JavascriptExecutor js, String username, String password) {
		try{
			js.executeScript("arguments[0].value='" + username +"'", driver.findElement(By.id("email")));
			js.executeScript("arguments[0].value='" + password + "'", driver.findElement(By.id("pass")));
			js.executeScript("arguments[0].click();", driver.findElement(By.id("loginbutton")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickProfileButton(JavascriptExecutor js) {
		try {
			js.executeScript("document.getElementById('profile_pic_header_100016247323286').click();");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void hoverOverEditProfile(WebDriver driver, JavascriptExecutor js) {
		try {
			js.executeScript("arguments[0].hover();", driver.findElement(By.id("u_jsonp_4_3")));
//			js.executeScript("document.getElementById('u_jsonp_4_d').onmouseover()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickUpdateProfilePic(WebDriver driver, JavascriptExecutor js) {
		try {
			js.executeScript("arguments[0].click();", driver.findElement(By.id("u_jsonp_4_d")));
//			js.executeScript("document.getElementById('u_jsonp_4_d').click()");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
