package executableFile;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import keywords.Keywords;

public class ExecutableFile {
	private static final String FIREFOXDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\geckodriver.exe";
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\chromedriver.exe";
	private static final String IEDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\IEDriverServer.exe";
	private static final String URL = "http://www.optimusinfo.com/contact-us/";
	private static final long TimeOut = 10;
	private static final String enteredText = UUID.randomUUID().toString();
	private static final String changedText = UUID.randomUUID().toString();
	private static final String url_new = "https://www.facebook.com/";
	private static final String username = "uditkhhh@gmail.com";
	private static final String password = "selenium1234";
	private static WebDriver driver;

	public static void main(String[] args) {
		ExecutableFile exe = new ExecutableFile();
		Keywords keyword = new Keywords();

		/*		Working Code		*/
//		exe.openBrowser("Chrome");
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		keyword.navigateToUrl(js, URL);
//		keyword.enterTextInMsgBox(driver, js, enteredText);
//		keyword.getMessageBoxText(js);
//		keyword.changeTextMessageBox(js, changedText);
//		exe.closeDriver();
		
		exe.openBrowser("Chrome");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		keyword.navigateToUrl(js, url_new);
		keyword.loginToFb(driver, js, username, password);
		keyword.clickProfileButton(js);
		keyword.hoverOverEditProfile(driver, js);
		keyword.clickUpdateProfilePic(driver, js);
		exe.closeDriver();
		

	}

	public void openBrowser(String browserType) {
		try {
			System.out.println("Opening Browser: " + browserType);
			if (browserType.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", FIREFOXDRIVERPATH);
				driver = new FirefoxDriver();
			} else if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH);
				driver = new ChromeDriver();
			} else if (browserType.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", IEDRIVERPATH);
				WebDriver driver = new InternetExplorerDriver();
			}
			driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateTo(String URL) {
		try {
			System.out.println("Navigating to the site: " + URL);
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDriver() {
		try {
			System.out.println("Closing the browser.");
			driver.quit();
			System.out.println("Browser closed");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

