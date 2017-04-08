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
	private static final String URL = "https://www.freecharge.in/";
	private static final long TimeOut = 10;
	private static final String phoneNum = "9555371977";
	private static WebDriver driver;

	public static void main(String[] args) {
		ExecutableFile exe = new ExecutableFile();
		Keywords keyword = new Keywords();

		exe.openBrowser("Chrome");
		exe.navigateTo(URL);
		keyword.enterPhoneNum(driver, phoneNum);
		keyword.selectAirtelOperator(driver);
		keyword.tapSubmitButton(driver);
		keyword.tapViewAllButton(driver);
		keyword.getTotalRecommendedPlans(driver);
		keyword.getAllFullTalktimeoffers(driver);
		keyword.checkSMSPlans(driver);
		keyword.clickFullTTButtton(driver);
		keyword.checkOtherPlans(driver);
		keyword.selectLeastValidityPlan(driver);
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
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TimeOut, TimeUnit.SECONDS);
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

