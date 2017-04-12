package executableFile;

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
//	private static final String URL = "https://www.freecharge.in/";
	private static final long TimeOut = 10;
	private static final String URL1 = "http://demoqa.com/droppable/";
	private static final String URL2 = "http://store.demoqa.com/";
	private static final String URL3 = "https://www.google.co.in/";
	private static final String textToEnter = "Sample Highlight";
	private static final String URL4 = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_accept";
	private static final String filePath = System.getProperty("user.dir") + "\\lib\\cglib-nodep-3.2.4.jar";
	private static WebDriver driver;

	public static void main(String[] args) {
		ExecutableFile exe = new ExecutableFile();
		Keywords keyword = new Keywords();
		
		/*		Working Code		*/
//		exe.openBrowser("Chrome");
//		exe.navigateTo(URL1);
//		keyword.dragAndDrop(driver);
//		exe.closeDriver();
		
		/*		Working Code		*/
//		exe.openBrowser("Chrome");
//		exe.navigateTo(URL2);
//		keyword.selectDropdownOption(driver);
//		exe.closeDriver();
		
		/*		Working Code		*/
//		exe.openBrowser("Chrome");
//		exe.navigateTo(URL3);
//		keyword.enterText(driver, textToEnter);
//		keyword.highlightEnteredText(driver, textToEnter);
//		keyword.rightClickAndCut(driver);
//		exe.closeDriver();

		exe.openBrowser("Chrome");
		exe.navigateTo(URL4);
		keyword.clickChooseFileButton(driver);
		keyword.sendFilePath(driver, filePath);
//		keyword.rightClickAndCut(driver);
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
