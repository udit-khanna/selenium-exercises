package executable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import keywords.Keywords;
import keywords.Keywords2;

public class ExecutableFile {
	private static final String FIREFOXDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\geckodriver.exe";
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\chromedriver.exe";
	private static final String IEDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\IEDriverServer.exe";
	private static final long TimeOut = 10;
	private static final String URL_First = "http://demoqa.com/draggable/";

	private static final int x = 100;
	private static final int y = 10;
	private static final String URL_Second = "https://www.makemytrip.com/";
	private static final String verifyText = "Sign in with your Google Account";
	private static final String verificationText = "Training Batch Starts from 29th April '17";
	private static WebDriver driver;

	public static void main(String[] args) {
		ExecutableFile exe = new ExecutableFile();
		Keywords keyword = new Keywords();
		Keywords2 keyword2 = new Keywords2();

		/*		working code		*/
//		 exe.openBrowser("Chrome");
//		 exe.navigateTo(URL_First);
//		 keyword.dragAndDrop(driver, x, y);
//		 exe.closeDriver();

//		 exe.openBrowser("Firefox");
//		 exe.navigateTo(URL_Second);
//		 keyword.alertClose(driver);
//		 keyword.switchFrame(driver, verifyText);
//		 exe.closeDriver();
		
		/*		working code		*/		
//		exe.openBrowser("chrome");
//		exe.navigateTo("http://toolsqa.com/automation-practice-switch-windows/");
//		keyword2.switchFrame(driver, verificationText);
//		exe.closeDriver();
		
		/*		working code		*/		
//		exe.openBrowser("firefox");
//		exe.navigateTo("http://toolsqa.com/automation-practice-switch-windows/");
//		keyword2.timerAlertAccept(driver);
//		exe.closeDriver();
		
		exe.openBrowser("firefox");
		exe.navigateTo("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
		keyword.switchToFrame(driver);
		keyword.getCurrentValue(driver);

//		exe.openBrowser("firefox");
//		exe.navigateTo(URL_Second);
//		keyword.timerAlert(driver);

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
				driver = new InternetExplorerDriver();
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
