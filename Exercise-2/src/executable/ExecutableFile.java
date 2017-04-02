package executable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import keywords.Keywords;

public class ExecutableFile {
	private static final String FIREFOXDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\geckodriver.exe";
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\chromedriver.exe";
	private static final String IEDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\IEDriverServer.exe";
	private static final long TimeOut = 10;
	private static final String URL_First = "http://demoqa.com/draggable/";

	private static final int x = 100;
	private static final int y = 10;
	private static final String URL_Second = "http://toolsqa.com/automation-practice-switch-windows/";
	private static final String verifyText = "Selenium Online Trainings";
	private static WebDriver driver;

	public static void main(String[] args) {
		ExecutableFile exe = new ExecutableFile();
		Keywords keyword = new Keywords();
		// exe.openBrowser("Chrome");
		// exe.navigateTo(URL_First);
		// keyword.dragAndDrop(driver, x, y);
		// exe.closeDriver();

		// exe.openBrowser("Chrome");
		// exe.navigateTo(URL_Second);
		// keyword.switchFrame(driver, verifyText);
		// exe.closeDriver();

		exe.openBrowser("firefox");
		exe.navigateTo(URL_Second);
		keyword.timerAlert(driver);

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
