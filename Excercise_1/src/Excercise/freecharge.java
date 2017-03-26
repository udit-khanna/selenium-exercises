package Excercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Runfiles.Enter_number;
import Runfiles.getBrandNames;

public class freecharge {
	private static final String FIREFOXDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\geckodriver.exe";
	private static final String URL_Site = "https://www.freecharge.in/";
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir") + "\\Support_Files\\chromedriver.exe";
	private static final String INVALID_NUMBER = "1234";
	private static final String VALID_NUMBER = "9812345678";
	private static final long TimeOut = 10;
	private static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.setProperty("webdriver.gecko.driver", FIREFOXDriver_PATH);
		freecharge freechObj = new freecharge();
		freechObj.openBrowser("chrome");
		freechObj.navigateTo(URL_Site);
		getBrandNames getBrandNamesObj = new getBrandNames();
		getBrandNamesObj.getBrands(driver);
		Enter_number entrNumObj = new Enter_number();
		entrNumObj.enterNumber(driver, INVALID_NUMBER);
		entrNumObj.printErrorMessage(driver);
		freechObj.closeDriver();
		
		
		freechObj.openBrowser("Chrome");
		freechObj.navigateTo(URL_Site);		
		entrNumObj.enterNumber(driver, VALID_NUMBER);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entrNumObj.getDefaultOperator(driver);
		entrNumObj.getTotalOperators(driver);
		entrNumObj.selectAnOperator(driver, "IDEA");
		entrNumObj.clickNextButton(driver);
		entrNumObj.checkAmountField(driver);
		entrNumObj.clickViewAllButton(driver);
		entrNumObj.getTotalRecommendedPlans(driver);
		entrNumObj.selectEffectivePlan(driver);
		
		freechObj.closeDriver();

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
