package Excercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Runfiles.getBrandNames;

public class freecharge {
	private static final String FIREFOXDRIVERPATH = System.getProperty("user.dir")
			+ "\\Support_Files\\geckodriver.exe";
	private static final String URL_Site = "https://www.freecharge.in/";
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")
			+ "\\Support_Files\\chromedriver.exe";
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.gecko.driver", FIREFOXDriver_PATH);
		freecharge freechObj = new freecharge();
		freechObj.openBrowser("chrome");
		freechObj.navigateTo(URL_Site);
		getBrandNames getBrandNamesObj = new getBrandNames();
		getBrandNamesObj.getBrands(driver);
		freechObj.closeDriver();

	}
	
	public void openBrowser(String browserType){
		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", FIREFOXDRIVERPATH);
			driver = new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", CHROMEDRIVERPATH);
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
	}
	
	public void navigateTo(String URL){
		try{
			driver.get(URL);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closeDriver(){
		driver.quit();
	}

}
