package keywords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Keywords {

	private static final String mobileNumField = ".input-container._3udlq._22ixJ.undefined > input";
	private static final String operatorDropdownOptions = ".select-container.bR5l8.false > select > option";
	private static final String operatorDropdown = ".select-container.bR5l8.false > select";
	private static final String submitButton = ".btn._2eaVn";
	private static final String viewAllButton = "._3G6A5";
	private static final String recommendedPlans = "._3Ek1g > ul > li";
	private static final String offerDetails = "._3Ek1g > ul > li > div > p:nth-of-type(2)";
	private static final long timeoutInSeconds = 5;
	private static final String fullTtTab = "._13hzN > span:nth-of-type(2)";
	private static final String fullTalkTtOffers = "._3Ek1g > ul > li > div > p:nth-of-type(2)";
	private static final String offerValidityDetails = "._34E11 > span:nth-of-type(2)";
	private static final String internetPacksTab = "._13hzN > span:nth-of-type(4)";

	public void enterPhoneNum(WebDriver driver, String phonenum) {
		try {
			driver.findElement(By.cssSelector(mobileNumField)).sendKeys(phonenum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAirtelOperator(WebDriver driver) {
		try {
			driver.findElement(By.cssSelector(operatorDropdown)).click();
			List<WebElement> elements = new ArrayList<WebElement>();
			elements = driver.findElements(By.cssSelector(operatorDropdownOptions));
			for (WebElement e : elements) {
				if (e.getText().equalsIgnoreCase("Airtel")) {
					e.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tapSubmitButton(WebDriver driver) {
		try {
			driver.findElement(By.cssSelector(submitButton)).click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void tapViewAllButton(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(viewAllButton)));
			driver.findElement(By.cssSelector(viewAllButton)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getTotalRecommendedPlans(WebDriver driver) {
		try {
			System.out.println(
					"Total recommended plans: " + driver.findElements(By.cssSelector(recommendedPlans)).size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getAllFullTalktimeoffers(WebDriver driver) {
		try {
			List<WebElement> fullOffers = new ArrayList<>();
			fullOffers = driver.findElements(By.cssSelector(offerDetails));
			System.out.println("All Full Talktime Offers are: ");
			for (WebElement e : fullOffers) {
				if (e.getText().contains("Full Talktime"))
					System.out.println(e.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkSMSPlans(WebDriver driver) {
		try {
			List<WebElement> fullOffers = new ArrayList<>();
			fullOffers = driver.findElements(By.cssSelector(offerDetails));
			System.out.println("Does it contain SMS plans: ");
			for (WebElement e : fullOffers) {
				if (e.getText().contains("SMS"))
					System.out.println("Yes. Plan details are: " + e.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickFullTTButtton(WebDriver driver) {
		try {
			driver.findElement(By.cssSelector(fullTtTab)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkOtherPlans(WebDriver driver) {
		try {
			List<WebElement> elements = new ArrayList<>();
			elements = driver.findElements(By.cssSelector(fullTalkTtOffers));
			int flag = 1;
			for (WebElement e : elements) {
				if (!e.getText().contains("Full Talktime"))
					flag = 0;
				else
					flag = 1;
			}
			if (flag == 0)
				System.out.println("Other plans available in Full Talktime Tab");
			else
				System.out.println("No other type plans in Full Talktime tab");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectLeastValidityPlan(WebDriver driver) {
		try {
			driver.findElement(By.cssSelector(internetPacksTab)).click();
			List<WebElement> elements = new ArrayList<>();
			List<Integer> validityDetails = new ArrayList<>();
			elements = driver.findElements(By.cssSelector(offerValidityDetails));
			for (WebElement e : elements) {
				if (e.getText().equalsIgnoreCase("Unlimited Days")) {
					continue;
				} else {
					validityDetails.add(Integer.parseInt(e.getText().replace("Days", "").trim()));
				}
			}
			Collections.sort(validityDetails);
			System.out.println("Plan with least validity is: " + validityDetails.get(0) + " days");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
